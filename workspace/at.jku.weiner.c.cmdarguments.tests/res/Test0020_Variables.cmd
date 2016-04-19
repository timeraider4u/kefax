foobar1.o := -Wundef
foobar2.o := $(foobar1.o)
$(my) := -std=gnu89
$(x) := $(my-own)
