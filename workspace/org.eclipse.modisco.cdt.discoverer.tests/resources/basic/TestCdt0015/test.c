int doSomething(int a);
int doSomething(int b);
int doSomething(int a) {
  return 0;
}

// this one will not show up in attribute declarations for doSomething-FunctionDefinition!
int doSomething(int number);

int doSomething2(int a);
int doSomething2(int num);

//not allowed in C, not allowed in C++
//char doSomething2(int num);
//not allowed in C, but allowed in C++
//int doSomething2(char a);
//int doSomething2(char a) {
//	return 0;
//}

int doSomething2(int a) {
  return a;
}


int my(int a) {
  int x = doSomething(1);
  int y = doSomething2(x);
  
  return y;
}

//not allowed in C, but allowed in C++
//int doSomething2(int num, char a);
//int doSomething2(int num, char a) {
//  doSomething(1);
//  doSomething2(2);
//  doSomething2('a');
//	return num;
//}
