
#!/bin/bash
CLASSPATH="${CLASSPATH}:/usr/share/antlrworks/lib/antlrworks.jar"
CLASSPATH="${CLASSPATH}:/usr/share/antlr-3/lib/antlr3.jar"
CLASSPATH="${CLASSPATH}:/usr/share/jgoodies-forms/lib/forms.jar"
CLASSPATH="${CLASSPATH}:/tmp/jars/"
CLASSPATH="${CLASSPATH}:/tmp/jars/*"
export CLASSPATH="${CLASSPATH}:../bin/:."
cd ../bin/
java org.antlr.works.IDE
