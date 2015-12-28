#define FOO(A, B)	#A #B
FOO(BAR,)
FOO(,BAR)
FOO(,)
FOO( , )
