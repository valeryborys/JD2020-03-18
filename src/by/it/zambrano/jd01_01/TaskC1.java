package by.it.zambrano.jd01_01;
import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должна появится в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/
class TaskC1 {
    public static void main(String[] args) {
        int Sum=0,a,b;
        Scanner number = new Scanner(System.in);
        System.out.println("введите а");
        a = number.nextInt();
        System.out.println("введите в");
        b = number.nextInt();
        Sum = a + b;
        System.out.println("Sum = "+Sum);

    }
}
