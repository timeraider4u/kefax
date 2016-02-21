#define FOO(X, Y)	char X[255] = Y;
#define BAR(X, ...)		FOO(X, #__VA_ARGS__)
