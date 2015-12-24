#define FOOBAR(X) #X BAR(#X)
#define BAR(X) FOO(#X)
#define FOO(X) #X

FOO(abc);
BAR(abc);
FOOBAR(abc);
