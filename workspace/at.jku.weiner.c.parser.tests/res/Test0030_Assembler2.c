/*
 * Example taken from https://de.wikipedia.org/wiki/Integrierter_Assembler
 * Copyright (2015) Wikipedia authors - WP:CC BY-SA
 */
#include <stdio.h>

int main(void)
{
	int foo = 5;
	int bar = 4;

	/* Here starts the inline assembler section  in AT&T syntax */
	__asm (
			"add %1, %0\n\t"	/* Add the value of operand %1 to the value of operand %0. */
			"inc %0"			/* Increment the value of operand %0 by 1. */
			/* Definition of the constraints:
			 * They assign each C-variable a corresponding operator in the inline assembly code
			 * and tell the compiler which type (reading or writing) they are used inside
			 * the assembly code and to which register they are restricted.
			 * This ensures the correct and efficient handover of the values of variables
			 * between C and assembler sections.
			 */
		:	"+r"	(bar)	/* The variable bar can be read and written (+).
							 * Its value should be placed in a general register ('r').
							 * As a first operand it will be used in the assembler code section with the label
							 * %0.
							 * */
		:	"g"		(foo)	/* Restricts the usage of variable foo to read-only.
		 	 	 	 	 	 * It can be passed anyway ('g', in memory, in a register or as immediate value
		 	 	 	 	 	 * to the assembler section.
		 	 	 	 	 	 * As a second operand, it can be used with the label %1 in the assembler section.
		 	 	 	 	 	 */
		:	"cc"			/* Tells the compiler that the state has been changed
							 * (through the commands add and inc).
							 */
		:					/* do nothing more */
	);

	/* Here the C code continues */
	printf("Ergebnis: %i\n", bar);
	return 0;
}
