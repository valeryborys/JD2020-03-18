package by.it.szamostyanin.jd01_01;

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
        int i = sc.nextInt();
        int j = sc.nextInt();
        int k = i + j;
        String bin_i = Integer.toBinaryString(i);
        String bin_j = Integer.toBinaryString(j);
        String bin_k = Integer.toBinaryString(k);
        String hex_i = Integer.toHexString(i);
        String hex_j = Integer.toHexString(j);
        String hex_k = Integer.toHexString(k);
        String oct_i = Integer.toOctalString(i);
        String oct_j = Integer.toOctalString(j);
        String oct_k = Integer.toOctalString(k);

        System.out.println("DEC:" + i + "+" + j + "=" + k);
        System.out.println("BIN:" + bin_i + "+" + bin_j + "=" + bin_k);
        System.out.println("HEX:" + hex_i + "+" + hex_j + "=" + hex_k);
        System.out.println("OCT:" + oct_i + "+" + oct_j + "=" + oct_k);
    }
}
