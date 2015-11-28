#define PI		3.1415926535897932
#define NAME	"Nobody"
#define NUMBER	2

#define X		NUMBER

#define MAIN	int main(void)

// nasty, but valid
#define long	int

MAIN {
	long d = X - NUMBER;
	return d;
}
