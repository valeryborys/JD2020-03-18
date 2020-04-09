package by.it.tolstik.jd01_10;

public class Bean {
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 2, b = 3)
    static double max(int a, int b) {
        return Math.max(a, b);
    }

    @Param(a = 1, b = 1)
    double min(int a, int b) {
        return Math.min(a, b);
    }

    @Param(a = 4, b = 5)
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }

}
