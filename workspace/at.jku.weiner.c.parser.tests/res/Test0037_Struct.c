#include <stdio.h>
#include <string.h>

struct employee {
	int ident;
	char name[250];
} phil;

struct employee joe = {0x007, "Joe Nobody"};

int main(void) {
	printf("sizeof(joe.ident)=%lu\n", sizeof(joe.ident));
	printf("sizeof(joe.name)=%lu\n", sizeof(joe.name));
	printf("sizeof(joe)=%lu\n", sizeof(joe));
	phil.ident = 0x008;
	strcpy(phil.name, "Phil Morrison");
	printf("joe.ident=%d\n", joe.ident);
	printf("joe.name=%s\n", joe.name);
	printf("phil.ident=%d\n", phil.ident);
	printf("phil.name=%s\n", phil.name);
	return 0;
}
