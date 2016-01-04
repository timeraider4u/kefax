#define foo 1
#define LIN <include/file-foo.h>
#include LIN
#define LIN2 "../myinclude/include/foo.h"
#include LIN2

#include <include/foo/foo.h>
#include "../myinclude/include/foo/foo.h"
