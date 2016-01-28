#define FOO(X,Y,Z...) printf(X##z, Y, ##Z)
#define BAR(X,Y,Z...) printf(X##z, Y 1. ##Z)
FOO(a, b);
FOO(a, b, c);
FOO(a, b, c, d);
BAR(a, b);
BAR(a, b, 2);
BAR(a, b, 2, 3);
