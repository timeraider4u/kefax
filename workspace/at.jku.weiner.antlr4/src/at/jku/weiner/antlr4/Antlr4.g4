grammar Antlr4;

antlr4: helloWorld+;

helloWorld: 	'Hello' ID 
			|	'Hallo' 'static'? ID 
;

ID: [a-zA-Z]+;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
