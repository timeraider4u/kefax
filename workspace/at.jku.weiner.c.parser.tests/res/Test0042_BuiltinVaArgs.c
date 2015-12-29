// can be found in <stdarg.h>
// this is not a macro!!!
// see https://gcc.gnu.org/bugzilla/show_bug.cgi?id=6159
typedef __builtin_va_list my_list;
my_list a;
