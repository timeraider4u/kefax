typedef struct {
	int counter;
} atomic_t;

int out_of_line_wait_on_atomic_t(atomic_t *, int (*)(atomic_t *), unsigned);
