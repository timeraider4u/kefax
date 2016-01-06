#define linux 1
#define FOO(x) __gcc_header(x)
//#define __gcc_header(x) #x
#define __gcc_header(x) #X.h
//#define __gcc_header(x) Y##Z
#define _gcc_header(x) FOO(linux) linux __gcc_header(linux) __gcc_header(linux/compiler-gcc##x.h)

_gcc_header(4)
