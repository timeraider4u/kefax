foobar.o := -DFOO(X)=BAR(X)
foobar.o := -DBAR(x)=x -D_BAR2=5
foobar.o := -DSTR(s)=s
foobar.o := -DFOOBAR(X)=FOO(X)(Y)
foobar.o := -DSTR(s)=FOO(BAR(s))
foobar.o := -DFOOBAR(X,Y)=FOO(X),Y
foobar.o := -Dnostdinc
foobar.o := -Disystem=include