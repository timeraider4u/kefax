#define FOOBAR foobar
#ifdef FOOBAR
	#define FOO BAR
	int foo = 0;
#endif /* endif FOOBAR */
FOO
