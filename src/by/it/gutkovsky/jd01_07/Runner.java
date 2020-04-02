package by.it.gutkovsky.jd01_07;

class Runner {

    public static void main(String[] args) {

        Scalar var = new Scalar("3.1415");
        Scalar var1 = new Scalar(var);
        System.out.println(var);

        Var vector = new Vector("{1.0, 2.0, 4.0}");
        System.out.println(vector);
// check toString
        Matrix matrix = new Matrix( "{{ 1.0, 2.0}, { 3.0, 4.0}}");
        System.out.println(matrix);
    }
}
