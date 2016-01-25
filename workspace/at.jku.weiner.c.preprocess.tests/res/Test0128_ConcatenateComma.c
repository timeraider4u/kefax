#define FOO(X,Y,Z...) printf(X##z, Y, ##Z)
FOO(a, b);
FOO(a, b, c);
FOO(a, b, c, d);
