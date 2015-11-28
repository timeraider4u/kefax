void doSomething() {
	goto target;
	printf("will never be reached\n");
	target: printf("reached target\n");
}
