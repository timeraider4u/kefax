/*
 * leads to error during compilation!!!
*/
#define MYDEF
#include "bar.h"

#include <stdio.h>

int main(void) {
	NUMBER number = 5;
	printf("Number='%d'\n", number);
	return 0;
}
