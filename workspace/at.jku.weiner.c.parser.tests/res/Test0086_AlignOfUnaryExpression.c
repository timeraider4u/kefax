struct Employee {
	int id;
};

struct Employee * emp;
long l = __alignof__(emp->id);
