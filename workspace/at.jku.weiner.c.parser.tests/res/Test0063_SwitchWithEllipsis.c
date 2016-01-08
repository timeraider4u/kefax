int doSomething(char argc) {
	switch (argc) {
		case 0 ... 28:
			return 0;
		case '0' ... '7': {
			break;
			}
		default: {
			return 2;
		}
	}
	return 1;
}
