package by.it.szamostyanin.jd01_04;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner (System.in);
        String string= sc.nextLine();
        buildOneDimArray(string);
    }

    static void printMulTable() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 10; j++) {
                System.out.printf("%d*%d=%-3d", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);                          //прочитали массив
        double start = array[0];                                        //выделили 0 элемент
        double stop = array[array.length-1];                            //выделили последний элемент
        InOut.printArray(array,"V",5);              //напичатали массив
        Helper.sort(array);                                             //отсортировали
        InOut.printArray(array,"V",4);              //напачатали после сортировки
        for (int i = 0; i < array.length; i++) {                        //перебрали все элементы по условию
            if (array[i]==start){                                       //условие
                System.out.println("Index of the first element="+i);    //напичатали
                break;                                                  //после нахождения прервали цикл
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i]==stop){
                System.out.println("Index of the last element="+i);
                break;
            }
        }

    }
}