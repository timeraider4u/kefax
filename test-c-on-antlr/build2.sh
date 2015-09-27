#CP="../libs/antlr-generator-3.5.3-patch.jar:."
CP="../libs/antlr-4.5.1-complete.jar:."
#java -cp ${CP} org.antlr.Tool C.g &&\
java -cp ${CP} org.antlr.v4.Tool C2.g && \
javac -cp ${CP} {Scope,C2*,C2*,Main2}.java && \
echo "" && \
echo "" && \
echo "" && \
echo "" && \
java -cp ${CP} Main2 test.c && \
java -cp ${CP} Main2 test2.c
#CP2="../libs/antlr-4.5.1-complete.jar:." && \
cat test.c | java -cp ${CP} org.antlr.v4.runtime.misc.TestRig C2 translation_unit -gui
#cat test2.c | java -cp ${CP} org.antlr.v4.runtime.misc.TestRig C2 translation_unit -gui


find . -name "*.java" -not -name "Scope.java" -not -name "Main.java" -not -name "Main2.java" -exec rm {} \;
rm *.class && \
rm *.tokens
