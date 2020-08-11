@echo off

javac -d "./bin/" -cp "./lib/hamcrest-core-1.3.jar;./lib/junit-4.13.jar;./lib/good.jar" "./src/text/TestFlushLeft.java"
java -cp "./lib/hamcrest-core-1.3.jar;./lib/junit-4.13.jar;./bin/;./lib/good.jar" org.junit.runner.JUnitCore text.TestFlushLeft