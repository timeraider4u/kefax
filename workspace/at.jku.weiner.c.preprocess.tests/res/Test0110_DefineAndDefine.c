#define FOO 1
#define BAR(X) #X
#define BAZ(X) BAR(X##FOO)

BAZ(foo)
