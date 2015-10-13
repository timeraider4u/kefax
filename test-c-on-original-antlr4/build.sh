function die() {
	echo "Die!!! reason='${1}'"
	exit 1
}

CP="../libs/antlr-4.5.1-complete.jar:."
java -cp ${CP} org.antlr.v4.Tool C.g4 || die
javac -cp ${CP} *.java || die
echo "" 
echo "" 
echo ""  
echo "" 
cat ../tests/testFunctDefs.c | java -cp ${CP} org.antlr.v4.runtime.misc.TestRig C compilationUnit -gui || die

find . -name "*.java" -not -name "Scope.java" -not -name "Main.java" -exec rm {} \; || die
rm *.class || die
rm *.tokens || die
echo "Done!"
