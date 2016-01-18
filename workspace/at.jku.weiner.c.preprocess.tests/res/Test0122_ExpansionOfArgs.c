#define FOO foo
#define BAR(X, Y) X Y
#define BAZ(X, Y) BAR(X, Y)
#define FOO2(X, Y) BAR(#X, #Y)
BAR(FOO, FOO)
BAR((FOO), -FOO-)
BAZ(FOO, FOO)
BAZ((FOO), (-FOO-))
FOO2(FOO, FOO)
FOO2((FOO), -FOO-)
FOO2((FOO,FOO), FOO$FOO)
