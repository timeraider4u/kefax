function die() {
	echo "${1}"
	exit 1
}

#FILE="./examples/empty.h"
#FILE="./examples/code.c"
FILE="./examples/error.h"
#FILE="./examples/includes.h"
FILE="./examples/reuseDef.c"

CP="../libs/antlr-4.5.1-complete.jar:."
java -cp ${CP} org.antlr.v4.Tool CPreprocess.g4 || die
javac -cp ${CP} *.java || die
echo ""
echo ""
echo ""
echo ""
cat "${FILE}" | java -cp ${CP} org.antlr.v4.runtime.misc.TestRig CPreprocess compilationUnit -gui

find . -name "*.java" -not -name "Scope.java" -not -name "Main.java" -exec rm {} \;
rm *.class || die
rm *.tokens || die
echo "Done!"
