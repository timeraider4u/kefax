typedef unsigned long	pteval_t;
typedef unsigned long	pmdval_t;
typedef unsigned long	pudval_t;
typedef unsigned long	pgdval_t;
typedef unsigned long	pgprotval_t;

typedef struct { pteval_t pte; } pte_t;

static inline __attribute__((always_inline)) __attribute__((no_instrument_function)) pte_t native_make_pte(pteval_t val)
{
	return (pte_t) { .pte = val };
} 
