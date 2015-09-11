grammar test;

options {forceHoisting=true;}

test: (foobar)+;

foobar: 
	{;/*do nothing relevant*/}
	({doSomething(); /*do another irrelevant stuff*/;} foo 
	| bar
	)
;

foo: {isValid()/*stupidPredicate*/}? MY;
bar: MY;

MY: 'my';
