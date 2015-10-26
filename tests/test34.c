union num {
	char numChar;
	float numFloat;
};

union num number;

int main(void) {
	// unsigned long size = (unsigned long)sizeof(number);
	printf("sizeof(number)=%lu\n", size);
	printf("sizeof(number.numChar)=%lu\n", sizeof(number.numChar));
	return 0;
}
