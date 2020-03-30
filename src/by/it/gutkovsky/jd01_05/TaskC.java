package by.it.gutkovsky.jd01_05;


import java.util.Arrays;

import static java.lang.Math.*;

 public  class TaskC {
    public static void main(String[] args) {
        task6();
        task7();
    }

    private static void task6() {

        double[] z = new double[(int) ((random() * 21) + 20)];
        double deltaX = (9. - 5.33)/(z.length-1) ;
//        System.out.println("deltaX =" + deltaX);
        double[] arrayX = new double[z.length];
        double x = 5.33;

        //create array z (1 step)
        for (int i = 0; i < z.length; i++) {
            z[i] = pow(((x * x) + 4.5), 1 / 3.);
            arrayX[i] = x;
            x = x + deltaX;

        }
        /*
        System.out.println("cheсk array z and x");
        for (int i = 0; i < z.length; i++) {
            System.out.printf("%6s%-5.4f z=%-5.4f", "При х=", arrayX[i], z[i]);
            System.out.println();
*/
            //print array z

            System.out.println("Массив A[]");
            int numberOfcolumns = 0;
            for (int j = 0; j < z.length; j++) {
                if (numberOfcolumns < 5) {
                    System.out.printf("%1s[%2d]=%6.5f ", "A", j, z[j]);
                    numberOfcolumns++;
                }
                if (numberOfcolumns == 5) {
                    System.out.println();
                    numberOfcolumns = 0;
                }
            }
            System.out.println();
            // find quantity of elements which have value more than 3.5
            int quantityOfElements = 0;
            for (double v : z) {
                if (v > 3.5) quantityOfElements++;
            }

            double[] b = new double[quantityOfElements];
            int indexFornewArray = 0;
            for (double v : z) {
                if (v > 3.5) {
                    b[indexFornewArray] = v;
                    indexFornewArray++;
                }
            }

            //print b
            System.out.println("Массив B[] из элементов массива A > 3.5");
            int numberOfcolumnsForArrayB = 0;
            for (int j = 0; j < b.length; j++) {
                if (numberOfcolumnsForArrayB < 4) {
                    System.out.printf("%1s[%2d]=%6.5f ", "B", j, b[j]);
                    numberOfcolumnsForArrayB++;
                }
                if (numberOfcolumnsForArrayB == 4) {
                    System.out.println();
                    numberOfcolumnsForArrayB = 0;
                }
            }
            System.out.println();
            // нахождение среднего геометрического значения
            double mult = 1;
            for (double v : b) {
                mult = mult * v;
            }

            double average = pow(mult, 1. / b.length);
            System.out.printf("Cреднее геометрическое значение равно %-20.4f", average);
            System.out.println();

        }


   private static void task7() {
        int[] a = new int[31];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (random() * 347 + 103);
        }
        int lengthForB = 0;

        for (int j = 0; j < a.length; j++) {
            if (a[j] * 0.1 > j) {
                lengthForB++;
            }
        }

        int[] b = new int[lengthForB];
        int n = 0;
        for (int j = 0; j < a.length; j++) {
            if (a[j] * 0.1 > j) {
                b[n] = a[j];
                n++;
            }
        }
        Arrays.sort(b);

        // печать массива А

        System.out.println("Array A:");
        printArrayIndexHorizontally(a, "a", 5);

        // печать массива b

        System.out.println("Array B:");
//        printArrayIndexHorizontally(b, "b", 5);

        printArrayIndexVertical(b, "b", 5);

    }

    private static void printArrayIndexHorizontally(int[] array, String name, int n) {

        int row = 0;
        int rowCounter = 0;

        //печатаю вверхнюю шапку
        System.out.print("╔");
        for (int i = 0; i < 12 * n - 1; i++) {
            System.out.print("═");
        }
        System.out.println("╗");

        //печатаем тело массива
        int column = 0;
        int k = array.length % n; // количество заполненных элементов в последней строке
        int z = 0; // количество элементов в последней строке

        for (int i = 0; i < array.length; i++) {
            if (column <= 5) {
                System.out.printf("║ %1s[%2d]=%-3d ", name, i, array[i]);
                column++;
            }
            if (column == 5) {
                System.out.print("║");
                System.out.println();
                if (k != 0) {
                    System.out.print("╠");

                    for (int j = 0; j <= column - 2; j++) {
                        System.out.print("═══════════╬");
                    }
                    System.out.print("═══════════╣");
                    System.out.println();
                    column = 0;
                    row++;
                } else {
                    if (rowCounter < array.length / n - 1) {
                        System.out.print("╠");

                        for (int j = 0; j <= column - 2; j++) {
                            System.out.print("═══════════╬");
                        }
                        System.out.print("═══════════╣");
                        System.out.println();
                        column = 0;
                        rowCounter++;
                    }
                }
            }
            if (row == array.length / n) {
                z++;
            }
        }
        if ((z - 1) == k && k != 0) {
            System.out.print("║");
            while ((n - (z - 1)) > 0) {
                System.out.print("           ║");
                z++;
            }
        }
        if (k != 0) {
            System.out.println();
        }
        System.out.print("╚");

        for (int i = 0; i < 12 * n - 1; i++) {
            System.out.print("═");
        }
        System.out.println("╝");
        System.out.println();
    }

    private static void printArrayIndexVertical(int[] array, String name, int column) {
        // определяем количество строк при выводе
        int quantityRows = 0;
        if (array.length % column == 0) {
            quantityRows = array.length / column;
        } else {
            quantityRows = (array.length / column) + 1;
        }
//        System.out.println("column = " + column);
//        System.out.println("quantityRows =" + quantityRows);

        //печатаю вверхнюю шапку
        System.out.print("╔");
        for (int i = 0; i < 12 * column - 1; i++) {
            System.out.print("═");
        }
        System.out.println("╗");

        // печатаем тело массива

        int columncalc = 0;
        int index = 0;
        int k = array.length % quantityRows; // количество элементов в последнем столбце
        if (k == 0) {
            k = quantityRows;
        }
        for (int i = 0; i < quantityRows; i++) {
            for (int j = 0; j < column; j++) {
                if (k > 0) {

                    if (columncalc < column && j != 0) {
                        System.out.printf("║ %1s[%2d]=%-3d ", name, index, array[index]);
                        columncalc++;
                        index = index + quantityRows;

                    } else {
                        if (j == 0) {
                            System.out.printf("║ %1s[%2d]=%-3d ", name, index, array[index]);
                            index = index + quantityRows;
                            columncalc++;
                        }
                    }

                } else {
                    if (columncalc < column && j != 0 && j != column - 1) {
                        System.out.printf("║ %1s[%2d]=%-3d ", name, index, array[index]);
                        columncalc++;
                        index = index + quantityRows;
                    } else {
                        if (j == 0) {
                            System.out.printf("║ %1s[%2d]=%-3d ", name, index, array[index]);
                            index = index + quantityRows;
                            columncalc++;
                        }
                        if (j == column - 1) {
                            System.out.print("║           ");
                        }
                    }
                }

            }
            columncalc = 0;
            k--;
            System.out.print("║");
            System.out.println();


            if (i != quantityRows - 1) {
                System.out.print("╠");
                for (int p = 0; p <= column - 2; p++) {
                    System.out.print("═══════════╬");
                }
                System.out.print("═══════════╣");
                System.out.println();
            } else {
                System.out.print("╚");

                for (int m = 0; m < 12 * column - 1; m++) {
                    System.out.print("═");
                }
                System.out.println("╝");
                System.out.println();
            }

            index = i + 1;

        }

    }
}
