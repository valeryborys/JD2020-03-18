package by.it.verbitsky.jd01_05;


import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step2() {
        System.out.println("\n Задание С-2");
        int left = 103;
        int right = 450;
        double[] masA = new double[31];
        for (int i = 0; i < masA.length; i++) {
            masA[i] = Math.round((Math.random() * (right - left + 1)) + left);
        }
        System.out.println("\nМассив А - сгенерированный случайными числами в диапозоне 103-450 и округленных до целого");
        printArray(masA, "masA");
        int countMasB = 0;
        for (int i = 0; i < masA.length; i++) {
            if (masA[i] % 10 > i) {
                countMasB++;
            }
        }
        double[] masB = new double[countMasB];

        int j = 0;
        for (int i = 0; i < masA.length; i++) {
            if (masA[i] % 10 > i) {
                System.arraycopy(masA, i, masB, j, 1);
                j++;
            }
        }
        System.out.println("\nМассив B содержащий элементы Массива А 10% которых больше индекса");
        printArray(masB, "masB");
        printGraficArray(masA,"A");
    }

    private static void step1() {
        System.out.println("\n Задание С-1");
        double z;
        int index = 0;
        double[] array = new double[30];
        for (double x = 5.33; x <= 9; x += 0.1) {
            z = Math.cbrt(x * x + 4.5);
            if (index < 30) {
                array[index++] = z;
            }
        }
        System.out.println("Массив A из значений функции на интервале 5,33 <= x <= 9");
        printArray(array, "Mas");

        int fIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 3.5) {
                fIndex = i;
                break;
            }
        }
        System.out.println("Новый массив B из значений массива А > 3.50000");
        double[] nArray = Arrays.copyOfRange(array, fIndex, array.length);
        printArray(nArray, "Arr");

        double midGeo = 1;
        for (double elem : nArray) {
            midGeo *= elem;
        }

        midGeo = Math.pow(midGeo, 1.0 / nArray.length);
        System.out.println("\n Среднее геометрическое эелементов нового массива = " + midGeo);
    }

    static void printArray(double[] arr, String name) {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 & i % 5 == 0) {
                System.out.println();
            }
            System.out.printf("%s[ %2d]: %-4.5f     ", name, i, arr[i]);
        }
        System.out.println();
    }

    static void printGraficArray(double[] arr, String name) {

        final String verticalLine = "\u2551";
        final String horizontalLine = "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                "\u2550\u2550\u2550\u2550\u2550";

        final String topLeftAngle = "\u2554";
        final String topRighttAngle = "\u2557";
        final String bottomLeftAngle = "\u255A";
        final String bottomRightAngle = "\u255D";

        final String leftT = "\u2560";
        final String rigtT = "\u2563";
        final String topT = "\u2566";
        final String botT = "\u2569";

        final String cross = "\u256C";

        int index = 0;
        int rowCount = ((arr.length+3)/5)*2+1;
        System.out.println("\nМассив "+name);
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < 5; j++) {
                //i = 0 - значит верхняя строка
                if (i == 0) {
                    if (j == 0) //i=0 j=0 - значит левый верхний угол
                        System.out.print(topLeftAngle + horizontalLine + topT);
                    if (j == 4) //j = 4 i = 0 - правый верхниуй угол
                        System.out.println(horizontalLine + topRighttAngle);
                    if (j > 0 & j != 4) {
                        //в остальных случаях гоним горизонтальную линию разделенную c Т-образным разрывом (только для 1 строки)
                        System.out.print(horizontalLine + topT);
                    }
                }
                //i 11 - последняя строка
                if (i == rowCount-1) {
                    //последняя строка
                    if (j == 0) //i=5 j=0 - значит левый нижний угол
                        System.out.print(bottomLeftAngle + horizontalLine + botT);
                    if (j == 4) //j = 4 i = 6 - правый нижний угол
                        System.out.println(horizontalLine + bottomRightAngle);
                    if (j > 0 & j != 4) {
                        //в остальных случаях гоним горизонтальную линию разделенную c Т-образным разрывом (только для 1 строки)
                        System.out.print(horizontalLine + botT);
                    }
                }
                if (i % 2 == 1) { //нечетные строки содержат значения
                    //System.out.print(verticalLine + "A[  ] = XXXXX");
                    System.out.printf("%s%s[ %-2.0f]=%-4.2f",verticalLine,name,(double)index,arr[index]);
                    index++;
                    if (j == 4) System.out.println(verticalLine);
                }

                if (i % 2 == 0 & i != rowCount-1 & i != 0) {//четные строки - рисуют горизональную линию
                    if (j == 0) {//левая стенка
                        System.out.print(leftT + horizontalLine + cross);
                    }
                    if (j == 4) {//правая стенка
                        System.out.println(horizontalLine + rigtT);
                    }
                    if (j > 0 & j != 4) {
                        System.out.print(horizontalLine + cross);
                    }
                }
            }
        }
    }
}
