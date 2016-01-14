GRAMMAR="C.g"
#FILE="../tests/test0072.c"
FILE="../tests/test0074.c"

CP="../libs/antlr-generator-3.5.3-patch.jar:."
java -cp ${CP} org.antlr.Tool "${GRAMMAR}" -Xconversiontimeout 100000 &&\
javac -cp ${CP} *.java && \
echo "" && \
echo "" && \
echo "" && \
echo "" && \
CP3="../libs/antlrworks-1.5.2.jar:${CP}:." && \
java -cp ${CP3} org.antlr.works.IDE

find . -name "*.java" -not -name "CParser.java" -exec rm {} \;
rm *.class && \
rm *.tokens
