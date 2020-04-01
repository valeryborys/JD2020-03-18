package by.it.bobrovich.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar scalar = new Scalar(3.141516);
        Var scalar1 = new Scalar(scalar);
        Var scalar2 = new Scalar("3.141516");
        double[] value = {1.0, 2.0, 3.0};
        Vector vector = new Vector(value);
        Vector vector1 = new Vector(vector);

        System.out.println(vector1);
    }
}
