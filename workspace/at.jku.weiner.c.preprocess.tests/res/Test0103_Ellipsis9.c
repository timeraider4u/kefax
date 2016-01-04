#define FOO(x...) printf(x)
FOO();
FOO( );
FOO(, );
FOO(, , );
FOO("abc");
FOO("abc", "def");
FOO( "abc", "def", "ghi");
