struct foo {
	int i;
	struct bar {
		int j;
	} __attribute__((__aligned__((2 << (3)))));
} __attribute__((__aligned__((2 << (3)))));
