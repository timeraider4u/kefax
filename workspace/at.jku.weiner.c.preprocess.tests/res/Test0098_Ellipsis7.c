#define FOO(...) fprintf (stderr, __VA_ARGS__)
FOO();
FOO( ,);
FOO("abc");
FOO("abc", "def");
FOO("abc", "def", "ghi");
