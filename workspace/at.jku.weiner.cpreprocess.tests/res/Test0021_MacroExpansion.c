#define foo() bar()

int bar() {
	return 0;
}

int main(void) {
	int foo = foo();
	return foo;
}
