#include <stdio.h>
#include <string.h>

struct employee {
	int id;
	char name[250];
} phil;

struct employee joe = {0x007, "Joe Nobody"};

int main(void) {
	printf("sizeof(joe.id)=%lu\n", sizeof(joe.id));
	printf("sizeof(joe.name)=%lu\n", sizeof(joe.name));
	printf("sizeof(joe)=%lu\n", sizeof(joe));
	phil.id = 0x008;
	strcpy(phil.name, "Phil Morrison");
	printf("joe.id=%d\n", joe.id);
	printf("joe.name=%s\n", joe.name);
	printf("phil.id=%d\n", phil.id);
	printf("phil.name=%s\n", phil.name);
	return 0;
}
