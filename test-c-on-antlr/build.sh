CP="../libs/antlr-generator-3.5.3-patch.jar:."
java -cp ${CP} org.antlr.Tool C.g &&\
javac -cp ${CP} *.java && \
echo "" && \
echo "" && \
echo "" && \
echo "" && \
java -cp ${CP} Main test.c && \
java -cp ${CP} Main test2.c
#CP2="../libs/antlr-4.5.1-complete.jar:." && \
#cat test2.c | java -cp ${CP2} org.antlr.v4.runtime.misc.TestRig C translation_unit -gui


find . -name "*.java" -not -name "Scope.java" -not -name "Main.java" -exec rm {} \;
rm *.class && \
rm *.tokens
