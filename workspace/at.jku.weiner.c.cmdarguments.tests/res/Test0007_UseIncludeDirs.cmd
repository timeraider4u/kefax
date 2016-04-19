foobar1.o := -Ifoo/bar/include -I./foobar/bar/include -IC:\system\include -Iinclude
foobar2.o := -isystem C:\system32\include -isystem /usr/lib/gcc/x86_64-pc-linux-gnu/4.8.4/include
foobar3.o := -D__FOO__
foobar4.o := -Ioutput -Iisystem/ -Iisystem -II/ -Ix -Io -ID -Inostdinc