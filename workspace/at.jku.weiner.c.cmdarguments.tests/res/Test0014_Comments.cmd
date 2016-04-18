#foobar.o := -DFOO(X)=BAR(X)
#foobar.o := -D"BAR(x)=#x" -D_BAR2=5
#foobar.o := -D"STR(s)=#s"
#foobar.o := -D"FOOBAR(X,Y)=FOO(X)##Y"
foobar.o := -DFOO=BAR# set foo to bar
