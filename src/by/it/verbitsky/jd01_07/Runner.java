package by.it.verbitsky.jd01_07;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Testing Task A");
        Var var = new Scalar(3.1415);
        Var varSc = new Scalar("3.1415");
        Scalar sc = new Scalar(3.1415);
        Scalar scalar = new Scalar(sc);

        System.out.println(var.toString());
        System.out.println(varSc.toString());
        System.out.println(scalar.toString());

        System.out.println("\nTesting Task B");
        double[] doubleArray = {1.0, 2.0, 4.0};
        double[] doubleArray2 = {3.0, 4.0, 5.0};
        String stringArray = "{1.0, 2.0, 4.0}";

        Var varB = new Vector(doubleArray);
        Var varBstr = new Vector(stringArray);
        Vector vectorX = new Vector(doubleArray2);
        Var varFromVector = new Vector(vectorX);

        System.out.println("Vector from array");
        System.out.println(varB.toString());
        System.out.println("Vector from String");
        System.out.println(varBstr.toString());
        System.out.println("Vector from Vector");
        System.out.println(varFromVector.toString());

        System.out.println("\nTesting Task C");
        double[][] matrixDouble = {{1.0, 2.0}, {3.0, 4.0}};
        double[][] matrixDouble2 = {{3.0, 4.0}, {5.0, 6.0}};

        Var varC = new Matrix(matrixDouble);
        Matrix matrixZ = new Matrix(matrixDouble2);
        Var varFromMatrix = new Matrix(matrixZ);
        Var varCstr = new Matrix("{{1.2, 2.3, 3.2}, {4,5,6}}");

        System.out.println("Matrix from array");
        System.out.println(varC.toString());
        System.out.println("Matrix from Matrix");
        System.out.println(varFromMatrix.toString());
        System.out.println("Matrix from String");
        System.out.println(varCstr.toString());
    }
}
