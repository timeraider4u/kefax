#define STR(x) FOO(x)
#define FOO(x) #x
char * c = STR(Hello world!);
