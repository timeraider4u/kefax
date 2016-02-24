struct temp {
	int i;
};

struct outer {
	//int ident;
	struct temp *in1;
	struct temp in2;
	union {
		struct temp in3;
	} inner4;
};
