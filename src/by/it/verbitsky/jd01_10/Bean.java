package by.it.verbitsky.jd01_10;

public class Bean {
    @Param(a = 2, b = 4)
    static double sum(int first, int second) {
        return first + second;
    }

    @Param(a = 7, b = 5)
    double max(int first, int second) {
        return Math.max(first, second);
    }

    @Param(a = 10, b = 14)
    static double min(int first, int second) {
        return Math.min(first, second);
    }

    double avg(int first, int second) {
        return (first + second) / 2.0;
    }
}
