#!/bin/bash
MYPWD=$(pwd)
OUT="./start-antlrworks.sh"
PLUGINS="/tmp/jars"

echo "" > ${OUT}

echo '#!/bin/bash' >> ${OUT}
echo 'CLASSPATH="${CLASSPATH}:/usr/share/antlrworks/lib/antlrworks.jar"' >> ${OUT}
echo 'CLASSPATH="${CLASSPATH}:/usr/share/antlr-3/lib/antlr3.jar"' >> ${OUT}
echo 'CLASSPATH="${CLASSPATH}:/usr/share/jgoodies-forms/lib/forms.jar"' >> ${OUT}

echo -n 'CLASSPATH="${CLASSPATH}:' >> ${OUT}
echo -n "${PLUGINS}" >> ${OUT} 
echo    '/"' >> ${OUT}

echo -n 'CLASSPATH="${CLASSPATH}:' >> ${OUT}
echo -n "${PLUGINS}" >> ${OUT} 
echo    '/*"' >> ${OUT}


#for FILE in $(find ${PLUGINS} -name "*.jar"); do
	##echo -n '<listEntry value="&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot; standalone=&quot;no&quot;?&gt;&#10;&lt;runtimeClasspathEntry externalArchive=&quot;/' >> ${OUT}
	## echo ${MYPWD} >> ${OUT}
	
	#echo -n 'CLASSPATH="${CLASSPATH}:' >> ${OUT}
	#echo -n ${FILE} >> ${OUT}
	#echo -n '"' >> ${OUT}
	
	##echo -n '&quot; path=&quot;3&quot; type=&quot;2&quot;/&gt;&#10;"/>' >> ${OUT}
#	echo "" >> ${OUT}
#done

echo 'export CLASSPATH="${CLASSPATH}:../bin/:."' >> ${OUT}

echo 'cd ../bin/' >> ${OUT}


#echo 'java -cp ${CLASSPATH}:. org.antlr.works.IDE' >> ${OUT}
echo 'java org.antlr.works.IDE' >> ${OUT}


chmod u+x ${OUT}
