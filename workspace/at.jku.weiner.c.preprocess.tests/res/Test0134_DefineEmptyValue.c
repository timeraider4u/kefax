#define FOO
#define BAR(X, Y) X ## Y
FOO
BAR(A, FOO)
BAR(FOO, B)
