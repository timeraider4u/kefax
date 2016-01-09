typedef struct foo {
	int i;
} bar;

bar my(int arg) {
	return (bar) { .i = arg };
}
