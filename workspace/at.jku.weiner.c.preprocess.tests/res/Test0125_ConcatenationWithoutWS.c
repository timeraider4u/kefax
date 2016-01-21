#define __FOO(X,Y) (X##Y)
#define _FOO(X,Y) __FOO(X,Y)
__FOO(1,A) __FOO(1,A)
_FOO(1,A) _FOO(1,A)
