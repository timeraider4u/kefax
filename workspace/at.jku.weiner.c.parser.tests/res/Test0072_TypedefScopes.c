typedef int fooA;
fooA barA_1;

void foobar() {
	typedef int fooB;
	fooA barA_2;
	fooB barB_1;
	{
		typedef int fooC;
		fooA barA_3;
		fooB barB_2;
		fooC barC_1;
		{
			typedef int fooD;
			fooA barA_4;
			fooB barB_3;
			fooC barC_2;
			fooD barD_1;
		}
	}
}
