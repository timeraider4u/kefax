#define FOO x
#define BAR(x) #x
foo
foo(y)
bar
bar(y)
Foo
Foo(y)
Bar
Bar(y)
FOO
FOO(y)
BAR
BAR(y)

BAR FOO
BAR(FOO(y))
BAR(Foo)
BAR(foo)

#define BAZ(z) FOO foo z Foo #z
baz(y)
BAZ(Foo)
BAZ(foo)
BAZ(FOO)
