package by.it.okatov.jd01_07;

class Runner {
    public static void main(String[] args) {
        double[] arr = {1.0, 2.0, 4.0};
        Vector vect = new Vector(arr);
        System.out.println(arr);
        System.out.println(vect);

        String s = "{1,2,4}";
        Vector vect2 = new Vector(s);

        System.out.println(s);
        System.out.println(vect2);

        double[][] arrd = {{1, 2}, {2, 3}};
        Matrix matrix = new Matrix(arrd);
        System.out.println("Initialization of matrix with double[][]: ");
        System.out.println(matrix);

        String s2 = "{{5,6},{7,8}}";
        matrix = new Matrix(s2);
        System.out.println("Initialization of matrix with String: ");
        System.out.println(matrix);

        Matrix m2 = new Matrix(matrix);
        System.out.println("Initialization of matrix with another matrix");
        System.out.println(m2);
    }
}
