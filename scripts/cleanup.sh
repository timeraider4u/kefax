#!/bin/bash
# cleanup.sh

DIR="./workspace"
function add() {
	for FILE in $(ls "${DIR}"); do
		BASE="${DIR}/${FILE}"
		GEN="${BASE}/src-gen"
		if [ -d "${GEN}" ]; then
			#echo "${GEN}"
			mkdir "${BASE}/src" &> /dev/null
		fi
	done
	for FILE in $(find "${DIR}" -name "${1}" -type d); do
		touch $FILE/"${2}"
		git add --force ${FILE}/"${2}"
	done
}

add "bin" ".keep_binary"
add "src-gen" ".keep_src_gen"
add "xtend-gen" ".keep_xtend_gen"

#rm -r ${DIR}/at.jku.weiner.c.{parser,preprocess}.{ui,ui.tests}
rm -r "test-c-on-antlr/classes" &> /dev/null
