#define FOO(x, y...) x (y); x (y)
FOO(fprintf);
FOO(fprintf,);
FOO(fprintf, );
FOO(fprintf, , );
FOO(printf, "abc");
FOO(printf, "abc", "def");
FOO(printf, "abc", "def", "ghi");
