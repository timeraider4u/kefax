#define FOOBAR 1
int foo = -1;
#ifndef FOOBAR
	#define FOO BAR
	int foo = 0;
#endif /* endif FOOBAR */

foo = FOO;
