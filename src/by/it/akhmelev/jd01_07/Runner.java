package by.it.akhmelev.jd01_07;

class Runner {
    public static void main(String[] args) {
        Scalar scalar1=new Scalar(3.1415);
        Var var2 = new Scalar(scalar1);
        Scalar scalar3=(Scalar)var2;
    }
}
