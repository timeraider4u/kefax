#if FOOBAR
	typedef int TYPE_FOO_BAR;
#elif FOO
	typedef int TYPE_FOO;
#elif BAR
	typedef int TYPE_BAR;
#else
	typedef int TYPE_BAZ;
#endif
