#!/bin/bash
MY_DIR=$(pwd)
LIB="${MY_DIR}/lib/antlr4-4.5.4-SNAPSHOT.jar"
SRC_DIR1="${MY_DIR}/src/org/antlr/parser/antlr4"
SRC_DIR2="${MY_DIR}/src-gen/org/antlr/parser/antlr4"
PKG_NAME="org.antlr.parser.antlr4"

function die() {
	local MSG="${1}"
	echo "${MSG}"
	exit 1
}

function runAntlr4Tool() {
	local FILE="${1}"
	if [ ! -e "${FILE}" ]; then
		die "Could not find '${FILE}'"
	fi
	if [ ! -e "${LIB}" ]; then
		die "Could not find '${LIB}'"
	fi
	java -cp "${LIB}:${SRC_DIR1}:${SRC_DIR2}" \
		org.antlr.v4.Tool \
		"${FILE}" \
		-o "${SRC_DIR2}" \
		-listener \
		-no-visitor  \
		-package "${PKG_NAME}" \
		-encoding UTF-8 \
		
		#-incTokenInVisit
}


rm -r "${SRC_DIR2}" || die "could not delete '${SRC_DIR2}'"
mkdir -p "${SRC_DIR2}" || die "could not create '${SRC_DIR2}'"

#runAntlr4Tool "${SRC_DIR1}/LexBasic.g4" || die
runAntlr4Tool "${SRC_DIR1}/ANTLRv4Lexer.g4" || die
runAntlr4Tool "${SRC_DIR1}/ANTLRv4Parser.g4" || die

