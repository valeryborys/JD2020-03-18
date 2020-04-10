package by.it.akhmelev.jd01_10;

public class Bean {

    @Param(a = 4, b = 5)
    double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 4, b = 5)
    static double max(int a, int b) {
        return Math.max(a, b);
    }

    double min(int a, int b) {
        return a < b ? a : b;
    }

    @Param(a = 4, b = 5)
    static double avg(int a, int b) {
        return (a + b) / 2.0;
    }

}
