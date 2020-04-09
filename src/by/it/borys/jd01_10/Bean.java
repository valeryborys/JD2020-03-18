package by.it.borys.jd01_10;

public class Bean {
    @Param(a=5,b=7)
    public static double sum(int a, int b){
      return a+b;
    }
    @Param(a=2,b=4)
    public static double max(int a, int b){
        return Math.max(a,b);
    }
    public double min(int a, int b){
        return Math.min(a,b);
    }
    @Param(a=3,b=5)
    public double avg(int a, int b){
        return (a+b)/2.0;
    }
}
