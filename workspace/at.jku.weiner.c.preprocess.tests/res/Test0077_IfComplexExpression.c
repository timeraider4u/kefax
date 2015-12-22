#define REQ_MAJOR	3
#define REQ_MINOR	2

#define MAJOR	4
#define MINOR	1

#define REQ(major, minor) ((major << 32) + minor >= ((REQ_MAJOR) << 32) + (REQ_MINOR))

#if REQ(MAJOR,MINOR)
	void foo_bar();
#endif
