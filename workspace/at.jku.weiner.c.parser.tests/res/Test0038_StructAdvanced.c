#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct empStruct {
	int ident;
	char name[250];
} employee;

struct empStruct joe = {0x007, "Joe Nobody"};
employee phil = {0x008, "Phil Morrison"};

void print(employee *emp) {
	printf("(*employee).ident=%d\n", (*emp).ident);
	printf("employee->name=%s\n", emp->name);
}

int main(void) {
	employee * newEmployee = malloc(sizeof(employee));
	if (newEmployee == NULL) {
		printf("Could not reserve space for new employee!\n");
		return -1;
	}
	print(&joe);
	print(&phil);
	newEmployee->ident = 0x009;
	strcpy(newEmployee->name, "Billy The Kid");
	print(newEmployee);
	free(newEmployee);
	return 0;
}
