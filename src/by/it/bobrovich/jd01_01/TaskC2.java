package by.it.bobrovich.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и 4 раза выводит их сумму с обозначением системы счисления на экран в
ДЕСЯТИЧНОМ ДВОИЧНОМ ШЕСТНАДЦАТИРИЧНОМ ВОСЬМИРИЧНОМ виде

Вот пример ввода с клавиатуры:
34 26

Тогда вывод ожидается такой (обратите внимание на регистр букв):
DEC:34+26=60
BIN:100010+11010=111100
HEX:22+1a=3c
OCT:42+32=74
*/
class TaskC2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = a + b;
        System.out.println("DEC:" + a + "+" + b + "=" + sum);
        //двоичная си
        String binStrA = Integer.toBinaryString(a);
        String binStrB = Integer.toBinaryString(b);
        String binStrSum = Integer.toBinaryString(sum);
        System.out.println("BIN:" + binStrA + "+" + binStrB + "=" + binStrSum);
        //шестнадцатиричная си
        String hexStrA = Integer.toHexString(a);
        String hexStrB = Integer.toHexString(b);
        String hexStrSum = Integer.toHexString(sum);
        System.out.println("HEX:" + hexStrA + "+" + hexStrB + "=" + hexStrSum);
        //восьмиричная си
        String octStrA = Integer.toOctalString(a);
        String octStrB = Integer.toOctalString(b);
        String octStrSum = Integer.toOctalString(sum);
        System.out.println("OCT:" + octStrA + "+" + octStrB + "=" + octStrSum);

    }

}
