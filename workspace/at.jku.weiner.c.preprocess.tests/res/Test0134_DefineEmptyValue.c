#define FOO
#define BAR(X, Y) X ## Y
#define BAZ(X, Y) BAR(X##Y, X##Y)
FOO
BAR(A, FOO)
BAR(FOO, B)
BAZ(A, B)
BAZ(A, FOO)
BAZ(FOO, B)
