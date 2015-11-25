#define BAR(X) BAZ(X)
#define BAZ(X) #X
#define FOO 64
BAZ(FOO)
BAR(FOO)
