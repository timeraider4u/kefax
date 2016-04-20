foo.o := gcc -Wall foobar.c

foo2.o: $(foo.o)

bar.o: 

foobar.o:
	foo2.o
	$(bar.o)

baz.o:

