package by.it.zambrano.jd01_01;
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
        int sum1,number1,number2;
        String sum2,sum3,sum4;
        Scanner inputNumScanner = new Scanner(System.in);
        System.out.println("Enter First Number: ");
        number1 = inputNumScanner.nextInt();
        System.out.println("Enter Second Number: ");
        number2 = inputNumScanner.nextInt();
        sum1=number1+number2;
        sum2= Integer.toBinaryString(sum1);
        sum3= Integer.toHexString(sum1);
        sum4= Integer.toOctalString(sum1);
        System.out.println("DEC:"+number1+"+"+number2+"="+sum1);
        System.out.println("BIN:"+ Integer.toBinaryString(number1)+"+"+ Integer.toBinaryString(number2)+"="+sum2);
        System.out.println("HEX:"+ Integer.toHexString(number1)+"+"+ Integer.toHexString(number2)+"="+sum3);
        System.out.println("OCT:"+ Integer.toOctalString(number1)+"+"+ Integer.toOctalString(number2)+"="+sum4);
    }

}
