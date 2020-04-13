package by.it.bobrovich.jd01_10;

public class Bean {
    @Param(a = 2, b = 3)
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 5, b = 8)
    static double max(int a, int b) {
        if (a > b) return a;
        else return b;
    }

    @Param(a = 2, b = 4)
    double min(int a, int b) {
        if (a < b) return a;
        else return b;
    }

    double avg(int a, int b) {
        return (a + b) / 2.;
    }
}
