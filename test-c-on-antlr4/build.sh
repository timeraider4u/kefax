#FILE="../tests/test43.c"
#FILE="../tests/Test0045_FunctionDeclsStruct.c"
#FILE="../tests/HelloC.c"
#FILE="../tests/test0051.c"
#FILE="../tests/test0059.c"
FILE="../tests/test0060.c"

CP="../libs/antlr-4.5.1-complete.jar:."
java -cp ${CP} org.antlr.v4.Tool C.g4 && \
javac -cp ${CP} *.java && \
echo "" && \
echo "" && \
echo "" && \
echo "" && \
cat "${FILE}" | java -cp ${CP} org.antlr.v4.runtime.misc.TestRig C compilationUnit -gui
#cat ../tests/BinaryDigit.c | java -cp ${CP} org.antlr.v4.runtime.misc.TestRig C compilationUnit -gui

find . -name "*.java" -not -name "Scope.java" -not -name "Main.java" -exec rm {} \;
rm *.class && \
rm *.tokens && \
echo "Done!"
