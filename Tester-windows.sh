for jar in `ls ./lib/[bg]*.jar `
do
    printf "_________ $jar _________\n\n"
    javac -d "./bin/" -cp "./lib/hamcrest-core-1.3.jar;./lib/junit-4.13.jar;./lib/$jar" "./src/text/TestFlushLeft.java"
    java -cp "./lib/hamcrest-core-1.3.jar;./lib/junit-4.13.jar;./bin/;./lib/$jar" org.junit.runner.JUnitCore text.TestFlushLeft
    printf "\n"
done
read