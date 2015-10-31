//#define MYDEF 0
/* leads to error:
 * main2.c:7:2: error: unknown type name ‘NUMBER’,
*/
#include "bar.h"

#include <stdio.h>

int main(void) {
	NUMBER number = 5;
	printf("Number='%d'\n", number);
	return 0;
}
