namespace :package do
  task :all do
    ant.war :destfile => "target/companyNews.war" do
      fileset :dir => "src/main/webapp"
      lib :dir => "target/lib"
      classes :dir => "target/classes/main"
    end
  end
end
