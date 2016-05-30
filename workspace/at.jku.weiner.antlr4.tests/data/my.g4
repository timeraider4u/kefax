grammar my;

my: hello+;

hello: HELLO ID;

HELLO: 'hello' | 'hallo';

ID: '[a-zA-Z]+';
