#define FOO(X) int X;
#define BAR FOO
#define BAZ(X) BAR(X)
BAR(i)
BAZ(j)
