namespace :compile do
  task :all do
    run_compiler :folder => "main", :classpathref => "compile.classpath"
    run_compiler :folder => "test", :classpathref => "test.classpath"
  end

  def run_compiler(options)
    source_folder = "#{ant.project.getProperty("basedir")}/src/#{options[:folder]}/java"
    resources_folder = "#{ant.project.getProperty("basedir")}/src/#{options[:folder]}/resources"
    target_folder = "#{ant.project.getProperty("basedir")}/target/classes/#{options[:folder]}"
    ant.mkdir :dir => target_folder
    
    if File.directory? source_folder
      puts "Compiling #{source_folder}"
      ant.javac(:srcdir => source_folder, 
                :destdir => target_folder, 
                :source => "1.5", 
                :target => "1.5", 
                :debug => "true",
                :includeantruntime => "false") do
        classpath do
          path :refid => options[:classpathref]
          pathelement :location => "${basedir}/target/classes/main"
        end
      end
      ant.copy :todir => target_folder do 
        fileset :dir => source_folder, :excludes => "**/*.java"
      end
    end
    if File.directory? resources_folder
      ant.copy :todir => target_folder do 
        fileset :dir => resources_folder
      end
    end
  end
end
