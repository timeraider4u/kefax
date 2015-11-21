#define MIN(X, Y)	((X) < (Y) ? (X) : (Y))
int a = MIN(5,8);
int b = MIN(8, 5);
int c = MIN((5), 5);
int d = MIN(a + 1, 18);
int e = MIN(18, (b*2 + (*c)));
