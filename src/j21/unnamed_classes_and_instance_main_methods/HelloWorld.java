// Implicitly declared class => no package statement allowed

// 0. HelloWorld working
// 1. Access instance methods/variables.
// 2. Show error if no main() method present.
// 3. Show error if constructor coded.
// 4. What happens if we try to new HelloWorld()?
// 5. What happens if another class is in this file?

int x=5;

//HelloWorld(){}
void main() {
	System.out.println("Hello World!");
	showX();
	//new Other().test();
}
void showX(){
	System.out.println(x);
}

//class SomeOtherClass{}