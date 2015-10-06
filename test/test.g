grammar test;

options {forceHoisting=true;}

@members {
	private int i = 0;
	
	private void inc() {
		i++;
	}
	
	private boolean isValid() {
		return i > 1;
	}
}

test: (foobar)+;

foobar: 
	//{;/*do nothing relevant*/}
	(
		//{ ; ; /*do another irrelevant stuff*/;} 
		foo 
	| 
		bar { inc(); }
	)
;

foo: {isValid()/*stupidPredicate*/}? MY;
bar: MY;

MY: 'my';
