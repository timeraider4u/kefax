struct Employee {
	int ident;
};

struct Employee * emp;
long l = __alignof__(emp->ident);
