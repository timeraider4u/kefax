void foo() {
	// does not make sense? well it is just a test case
	// and I am not an assembler guru!
	// at least it compiles with gcc
	asm goto( "mov %[e], %[d]; jc %l[my_label]"
			:
			: ""
			: ""
			: my_label
	);
	my_label: return;
}
