CP="../libs/antlr-4.5.1-complete.jar:."
java -cp ${CP} org.antlr.v4.Tool C.g4 && \
javac -cp ${CP} *.java && \
echo "" && \
echo "" && \
echo "" && \
echo "" && \
cat test2.c | java -cp ${CP} org.antlr.v4.runtime.misc.TestRig C compilationUnit -gui && \
rm *.java && \
rm *.class && \
rm *.tokens && \
echo "Done!"
