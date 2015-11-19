#define PI		3.1415926535897932
#define NAME	"Nobody"
#define INC		<stdio.h>

#define MAIN	int main(void)
#define NL		"\n"

#include <stdio.h>

// nasty, but valid
#define long	int

//#define d		0

MAIN {
	long d = 0;
	printf("%f", PI);
	printf("%s", NL);
	printf("%s", NAME);
	printf("%s", NL);
	return d;
}
