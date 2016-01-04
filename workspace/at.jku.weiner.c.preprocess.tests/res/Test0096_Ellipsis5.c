#define FOO(x, y, ...) fprintf(stdout, __VA_ARGS__)
FOO(foo, bar, );
