package by.it.okatov.jd01_10;

public class TaskA1 {
    public static void main(String[] args) {
        
    }

    @Param(firstArg = 4, secondArg = 5)
    public double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
