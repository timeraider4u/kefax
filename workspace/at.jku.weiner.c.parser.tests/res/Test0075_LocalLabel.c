void doSomething() {
	__label__ target;
	goto target;
	printf("will never be reached\n");
	target: printf("reached target\n");
}
