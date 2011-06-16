namespace :test do
  task :all => [:unit]

  task :unit do
    setup_folders_for "test"
    run_tests "test"
  end

  def run_tests(tests)
    ant.property :name => 'run-only', :value => "**/*Test.class"
    ant.junit :printsummary => "yes", :fork => "yes", :forkmode => "once", :failureproperty => "tests-failed" do
      classpath do
        path :refid => "test.classpath"
        pathelement :location => "${basedir}/target/classes/main"
        pathelement :location => "${basedir}/target/classes/#{tests}"
      end
      formatter :type => "xml"
      batchtest(:fork => "yes", :todir => "${basedir}/target/test-reports/#{tests}/xml") do
        fileset :dir => "${basedir}/target/classes/#{tests}", :includes => "${run-only}"
      end
    end
    if ant.project.getProperty("tests-failed")
      generate_reports_for tests
      ant.fail :message => "run of '#{tests}' failed"
    end
  end
  
  def setup_folders_for(tests)
    puts "creating dirs for #{tests}"
    folder = "#{ant.project.getProperty("basedir")}/target/test-reports/#{tests}"
    ant.delete :dir => folder, :includeEmptyDirs => true, :failonerror => true
    ant.mkdir :dir => folder
    ant.mkdir :dir => folder + "/xml"
    ant.mkdir :dir => folder + "/html"
  end
  
  def generate_reports_for(tests)
    ant.junitreport :todir => "${basedir}/target/test-reports/#{tests}/html" do
      fileset :dir => "${basedir}/target/test-reports/#{tests}/xml", :includes => "TEST-*.xml"
      report :format => "frames", :todir => "${basedir}/target/test-reports/#{tests}/html"
    end
  end
end
