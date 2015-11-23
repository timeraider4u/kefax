#define foo( )			foo_bar
#define foo(X)			{X}
#define foo(X, Y)		X + Y
#define foo(X, Y,Z)		X * Y - Z

int z = foo ( );
int a = foo(bar);
int b = foo(0,bar );
int c = foo (((bar)));
int d = foo((0) , (bar));
int e = foo(0,bar) (* (1));
int f = foo(0)(1);
int g = foo( (a,(b)));
int h = foo( (0,b),bar);
int i = foo(1, (bar,b));
int j = foo(1,(1),(1,1));
