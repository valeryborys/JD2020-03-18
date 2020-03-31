package by.it.gutkovsky.jd01_02;

import com.sun.org.apache.xpath.internal.objects.XBoolean;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int[][] array = step1(n);
        step2(array);
        step3(array);

    }

    public static int[][] step1(int n) {
        int[][] resultArray = new int[n][n];
        boolean containN = false;
        boolean containPlusN = false;
        boolean containMinusN = false;

        do {
            // fill in array
            for (int i = 0; i < resultArray.length; i++) {
                for (int j = 0; j < resultArray.length; j++) {
                    resultArray[i][j] = (int) (Math.random() * (n + n + 1)) - n;
                }
            }
            // check array
            for (int i = 0; i < resultArray.length; i++) {
                for (int j = 0; j < resultArray.length; j++) {
                    if (resultArray[i][j] == n) containPlusN = true;
                    if (resultArray[i][j] == (-n)) containMinusN = true;
                }
            }

            if (containPlusN == true && containMinusN == true) {
                containN = true;
            }
        } while (containN != true);

        // print array
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray.length; j++) {
                System.out.print(resultArray[i][j] + " ");
            }
            System.out.println();
        }
        return resultArray;
    }

    public static int step2(int[][] array) {

        /*
        Найти, вывести и вернуть сумму элементов исходной матрицы mas,
        расположенных между первым и вторымположительными элементами каждой строки.
        Сигнатура int step2(int[ ][ ] mas).
         */

        // проверка: есть ли в строке два положительных элемента
        int sum = 0;
        List<Integer> listj = new ArrayList<>();
        int s = 0; // counter
        for (int i = 0; i < array.length; i++) {
            s = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] > 0) {
                    listj.add(j);
                    s = s + 1;
                    if (s == 2) {
                        if (listj.get(0) != (j - 1)) {
                            for (int k = (listj.get(0) + 1); k < j; k++) {
                                sum = sum + array[i][k];
//                                System.out.println("промежуточная сумма = " + sum + " прибав значение" + array[i][k]);
                            }
                            j = array.length - 1;
                        }
                    }
                }
            }
            listj.clear();
        }
        System.out.println(sum);
        return sum;

    }

    public static int[][] step3(int[][] array) {
        /*
        Найти максимальный элемент(ы) в матрице и удалить из исходнойматрицы все строки и столбцы, его содержащие.
        Вывести в консоль и вернуть полученную матрицу. Сигнатура int[ ][ ] step3(int[ ][ ] mas).
         */

        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] > max) max = array[i][j];
            }
        }

//        System.out.println("max element = " + max);

        List<Integer> lineWithMax = new ArrayList<>();
        List<Integer> columnWithMax = new ArrayList<>();

        // находим координаты всех максимадбных элементов
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] == max) {
                    if (!lineWithMax.contains(i)) lineWithMax.add(i);
                    if (!columnWithMax.contains(j)) columnWithMax.add(j);
                }
            }
        }
        // проверка списка lineWithMax
//        for (int i = 0; i < lineWithMax.size() ; i++) {
//            System.out.println("вывод lineWithMax");
//            System.out.print(lineWithMax.get(i) + " ");
//        }
//        System.out.println();
//        // проверка списка columnWithMax
//        for (int i = 0; i < columnWithMax.size() ; i++) {
//            System.out.println("вывод columnWithMax");
//            System.out.print(columnWithMax.get(i) + " ");
//        }
//        System.out.println();

        int[][] resultArray = new int[(array.length - lineWithMax.size())][(array.length - columnWithMax.size())];
        int i1 = 0, j1 = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (!lineWithMax.contains(i) && !columnWithMax.contains(j)) { // если индекса нет с списке максимумов - добавляем в новый массив
//                    System.out.print(array[i][j] + " ");
                    resultArray[i1][j1] = array[i][j];
                    j1++;
                    if (j1 == (array.length - columnWithMax.size())) {
                        i1++;
                        j1 = 0;
                    }
                }
            }
//            System.out.println();
        }
        System.out.println("проверка вывода матрицы");

        for (int k = 0; k < (array.length - lineWithMax.size()); k++) {
            for (int m = 0; m < (array.length - columnWithMax.size()); m++) {
                System.out.print(resultArray[k][m] + " ");
            }
            System.out.println();
        }
        return resultArray;

    }


}
