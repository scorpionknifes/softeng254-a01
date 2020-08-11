@echo off

:choose
set /p FILE="Enter letter: " 

if "%FILE%"=="" (
    set FILE="good.jar"
    goto run
) else (
    set FILE="bad%FILE%.jar"
    goto run
)



:run
echo.
echo _________ %FILE% _________
echo.
javac -d "./bin/" -cp "./lib/hamcrest-core-1.3.jar;./lib/junit-4.13.jar;./lib/%FILE%" "./src/text/TestFlushLeft.java"
java -cp "./lib/hamcrest-core-1.3.jar;./lib/junit-4.13.jar;./bin/;./lib/%FILE%" org.junit.runner.JUnitCore text.TestFlushLeft
set FILE=
goto choose