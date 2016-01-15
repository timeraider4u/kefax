char do2(int c) __attribute ((__nothrow__ , __leaf__));
char do1(int c) __attribute__ ((__nothrow__));
char do3(int c) asm ("" "something");
char do4(int c) __asm ("" "something");
char do5(int c) __asm__ ("" "something");
