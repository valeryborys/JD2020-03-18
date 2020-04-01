package by.it.szamostyanin.jd01_01;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // System.out.println("Hello World!");
        Hello hello = new Hello();
        hello.printSlogan();
        hello.setSlogan("Привет мир");
        hello.printSlogan();

        Args argObject = new Args(args);
        argObject.printArgs();
    }
}
