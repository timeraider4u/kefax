grammar test;

test: (foobar)+;

foobar: 
	{;/*do nothing relevant*/}
	({; /*do another irrelevant stuff*/;} foo 
	| bar
	)
;

foo: {true/*stupidPredicate*/}? MY;
bar: MY;

MY: 'my';
