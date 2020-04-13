package by.it.okatov.jd01_10;

public class Bean {
    @Param(a = 4, b = 5)
    static double min(int a, int b) {
        return (a > b) ? b : a;
    }

    static double max(int a, int b) {
        return (a > b) ? a : b;
    }

    @Param(a = 8, b = 10)
    double sum(int a, int b) {
        return (a + b);
    }

    @Param(a = 22, b = 19)
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }

}
