GRAMMAR="C3.g"
FILE="../tests/test0072.c"

CP="../libs/antlr-generator-3.5.3-patch.jar:."
java -cp ${CP} org.antlr.Tool "${GRAMMAR}" &&\
javac -cp ${CP} {Scope,C*,C*,Main}.java && \
echo "" && \
echo "" && \
echo "" && \
echo "" && \
java -cp ${CP} Main "${FILE}" && \
CP3="../libs/antlrworks-1.5.2.jar:${CP}:." && \
java -cp ${CP3} org.antlr.works.IDE

find . -name "*.java" -not -name "Scope.java" -not -name "Main.java" -not -name "Main2.java" -exec rm {} \;
rm *.class && \
rm *.tokens
