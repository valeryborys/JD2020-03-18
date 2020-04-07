package by.it.lemesh.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var var1 = new Scalar("3.1415");
        double[] test2 = {1,2,3};
        Var var2 = new Vector (test2);
        double[][] test = {{1,2},{5,6}};
        Var var3 = new Matrix (test);
        Var var4 = new Matrix ("{{1,2},{3,4}}");

 /*       System.out.println(var1);*/
 //       System.out.println(var2);
        System.out.println(var4);
    }
}
