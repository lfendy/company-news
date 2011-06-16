$:.unshift File.dirname(__FILE__)
require 'ant'
require 'dependencies'
require 'compile'
require 'package'
require 'test'
require 'rake/clean'
CLEAN.include("target")

task :default => ['clean', 'dependencies:setup', 'compile:all', 'test:all', 'package:all']
