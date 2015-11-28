#define FOO(x, y) x ## y, #x ## #y
FOO(foo, bar)
