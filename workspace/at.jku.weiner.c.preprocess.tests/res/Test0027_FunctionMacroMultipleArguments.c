#define foo0( )			bar_foo
#define foo1(X)			{X}
#define foo2(X, Y)		X + Y
#define foo3(X, Y,Z)		X * Y - Z
#undef foo0
#define foo0( )			foo_bar

int z = foo0 ( );
int a = foo1(bar);
int b = foo2(0,bar );
int c = foo1 (((bar)));
int d = foo2((0) , (bar));
int e = foo2(0,bar) (* (1));
int f = foo1(0)(1);
int g = foo1( (a,(b)));
int h = foo2( (0,b),bar);
int i = foo2(1, (bar,b));
int j = foo3(1,(1),(1,1));
int k = foo0() + (foo1(a)) - foo2(foo, bar) * foo3(foo, bar, baaar);
