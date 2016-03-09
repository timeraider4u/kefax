#define foo(a)	0x ## a
#define bar(a)	1 ## .0 ## a

foo(5A)
bar(25)
