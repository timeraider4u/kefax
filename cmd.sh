gcc -E HelloC.c > Hello.output
diff HelloC.output HelloC.cdt.i --ignore-blank-lines --ignore-all-space --ignore-matching-lines='^#.*'
