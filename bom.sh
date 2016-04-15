#!/bin/bash
#find all occurences of UTF-8 BOM
#and remove them inside the MANIFEST.MF
#files, as otherwise we will get a
#java.io.IOException: invalid header field name: ï»¿Manifest-Version

function has_bom() { 
	head -c3 "${1}" | grep -q $'\xef\xbb\xbf';
}

function un_bom() {
	# file exists and has UTF-8 BOM
	echo "file '${1}' has UTF-8 BOM"
	mv "${1}" "${1}.bak" && \
	tail -c +4 "${1}.bak" > "${1}" && \
	echo "removed BOM from '${1}'" && \
	rm "${1}.bak"
}

function is_bom() {
	has_bom "${1}" && un_bom "${1}"
}

export -f has_bom
export -f un_bom
export -f is_bom
find . -name "MANIFEST.MF" -exec bash -c 'is_bom "${0}"' {} \;

