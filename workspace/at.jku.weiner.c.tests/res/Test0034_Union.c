#include <stdio.h>

int main(void) {
	// unsigned long size = (unsigned long)sizeof(number);
	printf("sizeof(number)=%lu\n", size);
	//printf("sizeof(number.numChar)=%lu\n", sizeof(number.numChar));
	printf("sizeof(float)=%lu\n", sizeof(float));
	// number.numChar = 65;
	printf("number.numChar(as decimal)=%d\n", number.numChar);
	printf("number.numChar(as char)=%c\n", number.numChar);
	printf("number.numFloat=%f\n", number.numFloat);
	// number.numFloat = 0.56789;
	printf("number.numChar(as decimal)=%d\n", number.numChar);
	printf("number.numFloat=%f\n", number.numFloat);
	return 0;
}
