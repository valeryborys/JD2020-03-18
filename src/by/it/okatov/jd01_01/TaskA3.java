package by.it.okatov.jd01_01;
/*
Измените переменные и строку вывода в программе так,
чтобы она рассчитывала и печатала следующее выражение
3*3+4*4=25
 */

//DONE
class TaskA3 {
    public static void main(String[] args) {

        int i = 3;
        int j = 4;
        int k = i * i + j * j;
        System.out.println(String.format("%s*%s+%s*%s=%s", i, i, j, j, k));
    }
}
