#define REQ_MAJOR	3
#define REQ_MINOR	2

#define MAJOR	1
#define MINOR	4

#define REQ(major, minor) ((major << 32) + minor >= ((REQ_MAJOR) << 32) + (REQ_MINOR))

#if REQ(MAJOR,MINOR)
	void foo_bar();
#endif
