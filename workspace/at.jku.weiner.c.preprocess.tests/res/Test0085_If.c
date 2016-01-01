#define __FOO 1234
#define __BAR __FOO
#if __FOO == __BAR
	void doSomething();
#endif
