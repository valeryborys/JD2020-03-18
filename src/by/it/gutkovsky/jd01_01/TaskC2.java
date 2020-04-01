package by.it.gutkovsky.jd01_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        //ввод чисел с клавиатуры
        int a = sc.nextInt();
        int b = sc.nextInt();
        // расчет суммы
        int sum = a + b;
        // вывод согласно задания
        // DEC
        System.out.println("DEC:" + a + "+" + b + "=" + sum);
        // BIN
        String  a2 = Integer.toString(a, 2);
        String  b2 = Integer.toString(b, 2);
        String sum2 = Integer.toString(sum, 2);
        System.out.println("BIN:" + a2 + "+" + b2 + "=" + sum2);
        //HEX
        String  a16 = Integer.toString(a, 16);
        String  b16 = Integer.toString(b, 16);
        String sum16 = Integer.toString(sum, 16);
        System.out.println("HEX:" + a16 + "+" + b16 + "=" + sum16);
        //OCT
        String  a8 = Integer.toString(a, 8);
        String  b8 = Integer.toString(b, 8);
        String sum8 = Integer.toString(sum, 8);
        System.out.println("OCT:" + a8 + "+" + b8 + "=" + sum8);

        sc.close();
    }



}
