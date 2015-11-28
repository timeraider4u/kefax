// nasty, but valid
#define int		double
int a = 2.5;
#undef int
int b = 2;
#define int		long
#undef int
int c = 2;
#undef int
int d = 4;
