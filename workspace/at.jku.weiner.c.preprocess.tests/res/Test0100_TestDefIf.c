# define if(...)	trace_if(__VA_ARGS__)
# define endif foo

# if 1
	if (abc)
		endif
# endif
