foobar.o := -D"FOO(X)=BAR(X)"
foobar.o := -D"BAR(x)=x" -D"_BAR2=5"
foobar.o := -D"STR(s)=s"
foobar.o := -D"FOOBAR(X)=FOO(X)(Y)"
foobar.o := -D"STR(s)=FOO(BAR(s))"
foobar.o := -D"FOOBAR(X,Y)=FOO(X),Y"
foobar.o := -D"nostdinc"
foobar.o := -D"isystem=include"
