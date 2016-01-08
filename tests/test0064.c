int foo() {
	return (0 || ({
		int z = 0;
		z;
	}));
} 
