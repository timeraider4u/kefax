CP="/home/adalgrim/weiner/Private/workspace/libs/antlr/antlr-3.5.3-SNAPSHOT.jar:."
antlrv3 C.g &&\
javac -cp ${CP} *.java && \
echo ""
echo ""
echo ""
echo ""
java -cp ${CP} CParser test.c

rm *.class
