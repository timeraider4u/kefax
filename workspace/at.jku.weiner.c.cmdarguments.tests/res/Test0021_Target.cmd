foo.o := gcc -Wall foobar.c

foo.o: $(foo.o)

bar.o: 

foobar.o:
	foo.o
	$(bar.o)
