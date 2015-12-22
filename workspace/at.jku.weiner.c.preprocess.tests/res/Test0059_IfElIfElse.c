//#define FOO 50
#define BAR 0
#if defined FOO
	void foo();
#elif defined BAR
	void bar();
#else	/* else ... */
	void no_foo_and_no_bar();
#endif
