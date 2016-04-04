# xtext-predicates
My try to get semantic predicates working under
XText, so that I can write a Xtext grammar for the
programming language C.

See also my post in the Eclipse forum:
https://www.eclipse.org/forums/index.php?t=msg&th=1069632

[![Build Status](https://travis-ci.org/timeraider4u/xtext-predicates.svg?branch=master)](https://travis-ci.org/timeraider4u/xtext-predicates)

# HOWTO - install and use:
Add https://timeraider4u.github.io/NeoEMF/ as Eclipse update site
and install the following features:
* 'NeoEMF Persistence Framework'
	(fr.inria.atlanmod.neoemf.core.feature.feature.group),
* 'NeoEMF Blueprints Adapter'
	(fr.inria.atlanmod.neoemf.graph.blueprints.feature.feature.group)
* NeoEMF Blueprints Implementations
	(fr.inria.atlanmod.neoemf.graph.blueprints.implementations.feature.feature.group)

Add https://timeraider4u.github.io/NeoEMF/ as Eclipse update site
and install the following features:
* 'Xtext Complete SDK'
	(org.eclipse.xtext.sdk.feature.group)

# HOWTO - development
Coming soon...

## More interesting links:
### C/C++ discoverer for Eclipse MoDisco forum thread:
http://www.eclipse.org/forums/index.php/t/366540/

### Free Grammars for Programming Languages: 
http://www.thefreecountry.com/sourcecode/grammars.shtml

### Grammarware grammars:
https://github.com/grammarware/slps/tree/master/topics/grammars
http://slps.github.io/zoo/index.html#c

### ANTLR tutorial:
http://meri-stuff.blogspot.co.at/2011/08/antlr-tutorial-hello-word.html

### ANTLRv3 grammars
http://www.antlr3.org/grammar/list.html

### ANTLRv4 grammar for C
https://github.com/antlr/grammars-v4/tree/master/c

### ANTLR grammar for C/C++ pre-processor:
http://wrice.blogspot.co.at/2013/12/antlr-grammar-for-cc-preprocessor.html

### XText documentation:
http://www.eclipse.org/Xtext/documentation/
http://help.eclipse.org/mars/index.jsp?topic=%2Forg.eclipse.xtext.doc

### Can XText parse General-purpose languages (like C)? -> Problem semantic predicates
http://stackoverflow.com/questions/5632262/can-xtext-be-used-for-parsing-general-purpose-programming-languages

### XText warning/error messages explained:
http://www.euclideanspace.com/software/development/eclipse/xtext/grammar/debuging/index.htm

### Is XText going to move to ANTLRv4? -> Short answer: No
https://www.eclipse.org/forums/index.php/t/640630/

### What are semantic predicates: 
http://meri-stuff.blogspot.co.at/2012/12/antlr-semantic-predicates.html

### Semantic predicates in XText - not supported yet:
http://stackoverflow.com/questions/13717565/xtext-solving-ambiguity-without-semantic-predicates
https://www.eclipse.org/forums/index.php/t/169313/
https://www.eclipse.org/forums/index.php/t/202846/
https://www.eclipse.org/forums/index.php/t/441096/

### XText Antlr generator source code:
https://github.com/eclipse/xtext/blob/master/plugins/org.eclipse.xtext.generator/src/org/eclipse/xtext/generator/parser/antlr/XtextAntlrGeneratorFragment.java

### What I am currently trying:
https://www.eclipse.org/forums/index.php?t=msg&th=1069632
### and
https://github.com/timeraider4u/xtext-predicates

### Predicate hoisting (and why hoisting is not allowed over actions):
http://www.antlr.org/papers/LL-star/predicate-hoisting.pdf

### My question in the corresponding Google Group:
Is it possible to enforce predicate hoisting over actions?

https://groups.google.com/forum/#!topic/antlr-discussion/UrZEt-uaMVA


### Currently working on: Force hoisting predicates over actions:
See https://github.com/antlr/antlr3/pull/177
See ./HOWTO-ANTLR.txt
See ./HOWTO-XTEXT.txt
