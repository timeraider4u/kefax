#!/bin/bash
MY_DIR=$(pwd)
java -cp "${MY_DIR}/lib/antlr4-4.5.4-SNAPSHOT.jar:${MY_DIR}/src/at/jku/weiner/antlr4:${MY_DIR}/src-gen/at/jku/weiner/antlr4" \
	org.antlr.v4.Tool \
	"${MY_DIR}/src/at/jku/weiner/antlr4/Antlr4.g4" -o "${MY_DIR}/src-gen/at/jku/weiner/antlr4" \
	-listener -no-visitor -package at.jku.weiner.antlr4 -encoding UTF-8 -incTokenInVisit


