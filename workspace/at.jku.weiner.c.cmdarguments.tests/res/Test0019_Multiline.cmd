foobar.o := -DFOO(X)=BAR(X) \
	-D"BAR(x)=#x"\
	-D_BAR2  \
   -D"STR(s)=#s" \
	-D"FOOBAR(X,Y)=FOO(X)##Y"
