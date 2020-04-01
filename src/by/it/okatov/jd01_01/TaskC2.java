package by.it.okatov.jd01_01;

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

        int c = a + b;

        System.out.println(String.format("DEC:%s+%s=%s", a, b, c));
        System.out.println(String.format("BIN:%s+%s=%s", Integer.toBinaryString(a), Integer.toBinaryString(b), Integer.toBinaryString(c)));
        System.out.println(String.format("HEX:%s+%s=%s", Integer.toHexString(a), Integer.toHexString(b), Integer.toHexString(c)));
        System.out.println(String.format("OCT:%s+%s=%s", Integer.toOctalString(a), Integer.toOctalString(b), Integer.toOctalString(c)));
    }
}
