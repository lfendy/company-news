namespace :dependencies do
  ivy_tasks = {
    :ivy_configure => "org.apache.ivy.ant.IvyConfigure",
    :ivy_resolve => "org.apache.ivy.ant.IvyResolve",
    :ivy_cachepath => "org.apache.ivy.ant.IvyCachePath",
    :ivy_retrieve => "org.apache.ivy.ant.IvyRetrieve",
  }
  
  ant.path :id => "ivy.classpath" do
    pathelement :path => "${basedir}/conf/build/bootstrap/ivy-2.2.0.jar"
  end

  ivy_tasks.each do |task_name, class_name|
    ant.taskdef :name => task_name,
                :classname => class_name, 
                :loaderRef => "ivy.loader", 
                :classpathref => "ivy.classpath"
  end
  
  task :setup do
    ant.ivy_configure :file => "${basedir}/conf/ivy/ivysettings.xml"
    ant.ivy_resolve :file => "${basedir}/conf/ivy/ivy.xml",  :transitive => "true"
    ant.ivy_cachepath :pathid => "compile.classpath", :conf => "compile", :type => "jar"
    ant.ivy_retrieve :pattern => "${basedir}/target/lib/[artifact]-[revision].[ext]", :sync => "true", :conf => "default"
  end
end
