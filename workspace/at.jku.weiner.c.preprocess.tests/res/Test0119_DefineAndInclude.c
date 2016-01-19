// Similar example can be found in Linux kernel
#define xyz 4
#define bar 1
#define __foo(x) #x
#define _foo(x) __foo(../myinclude/include/bar/baz##x.h)
#define foo(x) _foo(x)
foo(xyz)
#include foo(xyz)
