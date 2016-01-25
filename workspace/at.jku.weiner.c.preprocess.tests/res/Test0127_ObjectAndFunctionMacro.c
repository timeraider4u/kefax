#define FOO(X) int X;
#define BAR unsigned FOO
#define BAZ(X) BAR(X)
BAR(i)
BAZ(j)
