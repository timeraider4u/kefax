#!/bin/bash
MYPWD=$(pwd)
OUT="./CP_PLUGINS.tmp"
echo "" > ${OUT}
for FILE in $(find ~/Private/eclipse/plugins/ -name "*.jar"); do
	#echo -n '<listEntry value="&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot; standalone=&quot;no&quot;?&gt;&#10;&lt;runtimeClasspathEntry externalArchive=&quot;/' >> ${OUT}
	# echo ${MYPWD} >> ${OUT}
	
	echo -n '<path location="' >> ${OUT}
	echo -n ${FILE} >> ${OUT}
	echo -n '"/>' >> ${OUT}
	
	#echo -n '&quot; path=&quot;3&quot; type=&quot;2&quot;/&gt;&#10;"/>' >> ${OUT}
	echo "" >> ${OUT}
done

	