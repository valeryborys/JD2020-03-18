package by.it.szamostyanin.jd01_10;

public class Bean {
    double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 5, b = 7)
    static double max(int a, int b) {
        return a > b ? a : b;
    }

    @Param(a = 5, b = 7)
    static double min(int a, int b) {
        return a < b ? a : b;
    }

    @Param(a = 5, b = 7)
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
