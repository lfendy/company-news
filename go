#!/bin/bash

time java -jar conf/build/bootstrap/jruby-complete-1.6.0.jar -S rake -f conf/build/main.rb $@
