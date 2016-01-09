unsigned int i = 0;
unsigned int j;
unsigned int * k = &i;

void foo() {
	// does not make sense? well it is just a test case
	// and I am not an assembler guru!
	// at least it compiles with gcc
	asm ( "mov %[e], %[d]\n\t"
		  "mov %[f], %[e]"
		: [d] "=rm" (i)
		: [e] "rm" (*k),
		  [f] "i" (1),
		  "d" (j),
	);
}
