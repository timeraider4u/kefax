CP="../libs/antlr-generator-3.5.3-patch.jar:."
#CP="../libs/antlr-4.5.1-complete.jar:."
java -cp ${CP} org.antlr.Tool C.g &&\
#java -cp ${CP} org.antlr.v4.Tool C.g && \
javac -cp ${CP} {Scope,C*,C*,Main}.java && \
echo "" && \
echo "" && \
echo "" && \
echo "" && \
java -cp ${CP} Main test.c && \
java -cp ${CP} Main test2.c
#CP2="../libs/antlr-4.5.1-complete.jar:." && \
#cat test2.c | java -cp ${CP2} org.antlr.v4.runtime.misc.TestRig C translation_unit -gui

CP3="../libs/antlrworks-1.5.2.jar:${CP}:."
java -cp ${CP3} org.antlr.works.IDE

find . -name "*.java" -not -name "Scope.java" -not -name "Main.java" -not -name "Main2.java" -exec rm {} \;
rm *.class && \
rm *.tokens
