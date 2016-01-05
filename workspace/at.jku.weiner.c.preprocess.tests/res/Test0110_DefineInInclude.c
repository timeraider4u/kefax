#define __foo(x) #x
#define _foo(x) printf(__GNUC__, __GNUC__ ## __foo(linux/foo-bar##x.h), __foo(linux/foo-bar##x.h))
#define foo(x) _foo(x)
foo(__GNUC__)
