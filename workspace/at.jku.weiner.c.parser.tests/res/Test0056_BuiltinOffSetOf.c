struct foo {
	int i;
};

void bar(struct foo foobar) {
	__builtin_offsetof(struct foo, i);
}
