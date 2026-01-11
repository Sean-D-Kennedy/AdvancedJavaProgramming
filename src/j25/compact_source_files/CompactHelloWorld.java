
int x=5;
void main(){
    IO.println("Hello World: "+x);
    List<String> ls = new ArrayList<>();

}
void main(String[] args) { // launcher uses this one if it exists
    if (args.length == 0) {
        main(); // call the no-arg instance main
    } else {
        IO.println("Arguments (" + args.length + "):");
        for (var arg : args) {
            IO.println(" - " + arg);
        }
    }
}

void m(){}
class AnotherClass{}
