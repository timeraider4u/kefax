#define FOO(X, Y, Z) printf(X##Y ## Z)
FOO(a, b, c);
FOO(foo, bar, baz);
