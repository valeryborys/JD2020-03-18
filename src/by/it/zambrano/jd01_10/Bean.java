package by.it.zambrano.jd01_10;

public class Bean {
    public static double max(int a, int b){
        return a>b?a:b;
        //Спросить почему не подходит метод max() и min();
    }
    @Param(a=2,b=5)
    public double sum(int a, int b){
        return a+b;
    }
    @Param(a=2,b=5)
    public static double min(int a, int b){
        return a<b?a:b;
    }
    @Param(a=2,b=5)
    public double avg(int a, int b){
        return (a+b)/2.0;
    }
}
