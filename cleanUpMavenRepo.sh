#!/bin/bash
DIR=$(pwd)
REPO="${HOME}/.m2/repository"
cd "${REPO}"
rm -r antlr
rm -r org/antlr
rm -r org/xtext/
rm -r org/eclipse/xte*

rm -r "${REPO}/.cache"

cd "${REPO}/p2/osgi/bundle/"
rm -r antlr*
rm -r org.antlr*
rm -r org.xtext*
rm -r org.eclipse.xte*

cd "$DIR"
