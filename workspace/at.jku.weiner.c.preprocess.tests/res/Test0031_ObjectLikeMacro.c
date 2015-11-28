#define FOO 1024
#define BAR FOO
int foo1 = FOO;
int bar1 = BAR;
#undef FOO
#define FOO 64
int foo2 = FOO;
int bar2 = BAR;
