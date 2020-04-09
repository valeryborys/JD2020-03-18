package by.it.gutkovsky.jd01_10;

class Bean {
    @Param( b = 2) // значение для а будет браться по default (добавил от себя)
    static double sum(int a, int b) {
        return (a + b);
    }

    @Param(a = 3, b = 5)
    double max(int a, int b) {
        return Math.max(a, b);
    }

    static double min(int a, int b) {
        return a < b ? a : b;
    }

    @Param(a = 3, b = 3)
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
