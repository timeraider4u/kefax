struct foo {
	int i;
};

extern void myprintf(struct foo foobar);

void bar(struct foo foobar) {
	myprintf(foobar);
}
