#define FOO(line, val)	line ':' val
FOO(1, line)
#define line 1
#ifdef line
	MY_LINE;
#endif
#ifndef line
	NO_LINE;
#endif
#if line
	MY_LINE2;
#endif
