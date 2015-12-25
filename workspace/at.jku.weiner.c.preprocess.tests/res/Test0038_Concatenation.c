#define FOO(x, y) x ## y, #x #y
#define BAR(x, y) #x #y, x ## y
FOO(foo, bar)
BAR(foo, bar)
