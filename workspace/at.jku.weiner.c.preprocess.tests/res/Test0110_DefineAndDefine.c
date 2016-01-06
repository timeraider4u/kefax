#define FOO 1
#define BAR(X) #X
#define BAZ(X) BAR(X##FOO)
#define FOOBAR(X) BAZ(X)
BAZ(foo)
BAZ(FOO)
FOOBAR(FOO)
