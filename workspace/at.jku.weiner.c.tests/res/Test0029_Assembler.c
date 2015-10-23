/*
 * Example taken from https://en.wikipedia.org/wiki/Inline_assembler
 * Copyright (2015) Wikipedia authors - WP:CC BY-SA
 */
extern int errno;

int funcname(int arg1, int *arg2, int arg3)
{
	int res;
	/* The operating system will return a negative value on error;
	 * wrappers return -1 on error and set the errno global variable */
	if (-125	<=	res && res < 0) {
		errno	=	-res;
		res		=	-1;
	}
	return res;
}
