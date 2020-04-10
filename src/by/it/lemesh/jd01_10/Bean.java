package by.it.lemesh.jd01_10;

public class Bean {
    @Param(a=3, b=4)
    double sum(int a, int b){
        return a+b;
    }

    @Param(a=5, b=11)
    double avg(int a, int b){
        return (a+b)/2.0;
    }

    @Param(a=2, b=8)
    static double min(int a, int b){
        return Math.min(a, b);
    }

    static double max(int a, int b){
        return Math.max(a, b);
    }
}
