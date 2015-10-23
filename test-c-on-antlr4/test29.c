/*
 * Example taken from https://en.wikipedia.org/wiki/Inline_assembler
 * Copyright (2015) Wikipedia authors - WP:CC BY-SA
 */
extern int errno;

int funcname(int arg1, int *arg2, int arg3)
{
	int res;
	__asm__ volatile(
		"int $0x80"		/* make the request to the OS */
		: "=a"	(res)	/* return result in eax ("a") */
		"+b"	(arg1),	/* pass arg1 in ebx ("b") */
	);
	/* The operating system will return a negative value on error;
	 * wrappers return -1 on error and set the errno global variable */
	if (-125	<=	res && res < 0) {
		errno	=	-res;
		res		=	-1;
	}
	return res;
}
