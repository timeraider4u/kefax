#define FOO(X) #X
#define BAR(X) FOO(#X)
#define FOOBAR(X) #X BAR(#X)

FOO(abc);
BAR(abc);
FOOBAR(abc);
