#include <stdio.h>

const int	W_MONDAY = 1,
			W_TUESDAY = 2,
			W_WEDNESDAY = 3,
			W_THURSDAY = 4,
			W_FRIDAY = 5,
			W_SATURDAY = 6,
			W_SUNDAY = 7;

enum { MONDAY=1, TUESDAY, WEDNESDAY,
		THURSDAY, FRIDAY, SATURDAY,
		SUNDAY, };

enum { I_MONDAY=1, I_TUESDAY, I_WEDNESDAY,
		I_THURSDAY, I_FRIDAY, I_SATURDAY,
		I_SUNDAY} iAmInLove;

enum weekdays { M_MONDAY=1, M_TUESDAY, M_WEDNESDAY,
		M_THURSDAY, M_FRIDAY, M_SATURDAY,
		M_SUNDAY};
enum weekdays my_weekday = M_FRIDAY;

int main(void) {
	printf("Monday is %d. day of week\n", W_MONDAY);
	printf("Monday is %d. day of week\n", MONDAY);
	printf("Sunday is %d. day of week\n", W_SUNDAY);
	printf("Sunday is %d. day of week\n", SUNDAY);
	iAmInLove = I_FRIDAY;
	printf("The %d. day of the week is my favourite!\n", iAmInLove);
	printf("The %d. day of the week is my favourite!\n", my_weekday);
	return 0;
}
