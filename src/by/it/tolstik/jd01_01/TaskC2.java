package by.it.tolstik.jd01_01;

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
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int val = num1 + num2;
        System.out.println("DEC:" + num1 + "+" + num2 + "=" + val);
        System.out.println("BIN:" + Integer.toBinaryString(num1) + "+" + Integer.toBinaryString(num2) + "=" + Integer.toBinaryString(val));
        System.out.println("HEX:" + Integer.toHexString(num1) + "+" + Integer.toHexString(num2) + "=" + Integer.toHexString(val));
        System.out.println("OCT:" + Integer.toOctalString(num1) + "+" + Integer.toOctalString(num2) + "=" + Integer.toOctalString(val));
    }


}
