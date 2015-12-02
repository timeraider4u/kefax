#define FOO 64
#define BAR 0
#if defined FOO
	void foo();
	#if defined BAR
		void bar();
	#else
		void no_bar();
		#if FOO >= 64
			void foo_64();
		#else
			void foo_and_no_bar();
		#endif /* FOO >= 64 */
	#endif /* defined BAR */
#else
	void no_foo_and_no_bar();
#endif
