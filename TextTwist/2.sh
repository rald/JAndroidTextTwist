for JAVAFILE in $(find . -type f -name "*.java")
do
    JAVAFILES="$JAVAFILES $JAVAFILE"
done

javac -source 1.8 -target 1.8 -cp "android.jar" -d "obj" $JAVAFILES
