#define FOO(X, Y, Z) printf(X##Y ## Z)
#define BAR(X,Y,Z)printf(X ## Y##Z)
#define BAZ(X,Y,Z)printf(X##Y##Z)
FOO(a, b, c);
FOO(foo, bar, baz);
BAR(a, b, c);
BAR(foo, bar, baz);
BAZ(a, b, c);
BAZ(foo, bar, baz);
