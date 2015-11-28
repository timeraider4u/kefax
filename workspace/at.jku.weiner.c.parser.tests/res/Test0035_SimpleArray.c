#include <stdio.h>
#include <string.h>

char out[255] = "some output";

int main(void) {
	printf("%s\n", out);
	strcpy(out, "Hello World!");
	printf("%s\n", out);
	out[6] = 'w';
	printf("%s\n", out);
	return 0;
}
