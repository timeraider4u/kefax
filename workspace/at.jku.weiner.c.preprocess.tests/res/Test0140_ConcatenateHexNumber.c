#define foo(a)	0x ## a
#define bar(a)	1 ## .0 ## a
#define baz(a)	0x ## 08 ## 081 ## 0h0 ## 1e1

foo(5A)
bar(25)
baz(07)
