package by.it.verbitsky.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var var = new Scalar(3.1415);
        Var varSc = new Scalar("3.1415");
        Scalar sc = new Scalar(3.1415);
        Scalar scalar = new Scalar(sc);
        System.out.println(var.toString());
        System.out.println(varSc.toString());
        System.out.println(sc.toString());
        System.out.println(scalar.toString());
    }
}
