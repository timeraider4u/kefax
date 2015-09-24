CP="../antlr-generator-3.5.3-patch.jar:."
antlrv3 C.g &&\
javac -cp ${CP} *.java && \
echo ""
echo ""
echo ""
echo ""
java -cp ${CP} CParser test.c

rm *.java
rm *.class
