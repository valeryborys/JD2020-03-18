package by.it.sinevich.jd01_07;

public class Runner extends Var{
    public static void main(String[] args) {
        double[][] x = new double[][]{{1,2}, {3,4}};
        Var v1 = new Matrix(x);
        System.out.println(v1);

    }
}
