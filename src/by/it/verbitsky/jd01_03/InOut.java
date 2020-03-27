package by.it.verbitsky.jd01_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InOut {
    static double[] getArray(String line) {
        line = line.trim();
        String[] stringDobles = line.split(" ");
        double[] arr = new double[stringDobles.length];
        for (int i = 0; i < stringDobles.length; i++) {
            if (!stringDobles[i].equals(" "))
                arr[i] = Double.parseDouble(stringDobles[i]);
        }
        return arr;
    }

    static String getLine() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(inputStreamReader);
        return buffer.readLine();
    }

    static void printArray(double[] arr) {
        for (double v : arr) {
            System.out.printf("% 4.2f", v);
        }
        System.out.println();
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%d]: %-4.2f  ", name, i, arr[i]);
            if (i == columnCount - 1) {
                System.out.println();
            }
        }
        System.out.println();
    }


    public static double[] merge(double[] arr1, double[] arr2) {
        int n = arr1.length + arr2.length;
        double[] arr = new double[n];
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < n; i++) {
            if (i1 == arr1.length) {
                arr[i] = arr2[i2++];
            } else if (i2 == arr2.length) {
                arr[i] = arr1[i1++];
            } else {
                if (arr1[i1] < arr2[i2]) {
                    arr[i] = arr1[i1++];
                } else {
                    arr[i] = arr2[i2++];
                }
            }
        }
        return arr;
    }

    static void sort1(double[] arr) {
        //Если массив c 1 элементом - выходим из сортировки
        if (arr == null) {
            return;
        }
        if (arr.length >= 2) {
            //длина масивов - половина существющего
            //если кол-во элементов нечетное - массив Б будет больше
            double[] masA = Arrays.copyOfRange(arr, 0, arr.length / 2);
            double[] masB = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
            //System.arraycopy(arr, 0, masA, 0, arr.length / 2);
            //System.arraycopy(arr, arr.length / 2, masB, 0, arr.length - arr.length / 2);

            sort1(masA);
            sort1(masB);

            mergeArrays(masA, masB);
        }
    }

    static double[] sort2(double[] arr) {

        if (arr.length < 2) return arr;
        int m = arr.length / 2;
        double[] arr1 = Arrays.copyOfRange(arr, 0, m);
        double[] arr2 = Arrays.copyOfRange(arr, m, arr.length);

        return merge(sort2(arr1), sort2(arr2));
    }

    static void sorttest(double[] mas) {
        Arrays.sort(mas);
    }


    static double[] mergeArrays(double[] masA, double[] masB) {
        //взял с инета
        int n = masA.length + masB.length;
        double[] arr = new double[n];
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < n; i++) {
            if (i1 == masA.length) {
                arr[i] = masB[i2++];
            } else if (i2 == masB.length) {
                arr[i] = masA[i1++];
            } else {
                if (masA[i1] < masB[i2]) {
                    arr[i] = masA[i1++];
                } else {
                    arr[i] = masB[i2++];
                }
            }
        }
        System.out.println("массив из метода мерж:");
        printArray(arr);
        return arr;
    }

    static double[] mergeArrays1(double[] arrA, double[] arrB) {

        double[] masResult = new double[arrA.length + arrB.length];
        int masAIndex = 0;
        int masBIndex = 0;
        int count = arrA.length + arrB.length;

        int i = 0;
        while (i < count) {
            if (masAIndex <= arrA.length - 1 && masBIndex <= arrB.length - 1) {
                if (arrA[masAIndex] <= arrB[masBIndex]) {
                    masResult[i] = arrA[masAIndex];
                    masAIndex++;
                    continue;
                } else {
                    masResult[i] = arrB[masBIndex];
                    masBIndex++;
                    continue;
                }
            }

            if (masAIndex == arrA.length && masBIndex <= arrB.length - 1) {
                masResult[i] = arrB[masBIndex];
                masBIndex++;
                continue;
            }

            if (masBIndex == arrB.length && masAIndex <= arrA.length - 1) {
                masResult[i] = arrA[masAIndex];
                masAIndex++;
                continue;
            }
            i++;
        }
        System.out.println("массив из метода мерж:");
        printArray(masResult);
        return masResult;
    }

    static double[] mergeArrays2(double[] masA, double[] masB) {
        /*System.out.println("masA:");
        printArray(masA);
        System.out.println("masB:");
        printArray(masB);

         */
        double[] masResult = new double[masA.length + masB.length];
        int masAIndex = 0;
        int masBIndex = 0;
        int count = masA.length + masB.length;
/*
        System.out.println("кол-во элементов результирующего массива = " + count);
        System.out.println("Длина массивов перед присваиванием А, Б: " + masA.length + " " + masB.length);
        System.out.println("\n\n-------------------------Сравнимаем массивы \n массив masА");

        System.out.print("masA elements: ");
        for (double v : masA) {
            System.out.printf("%3.0f ", v);
        }

        System.out.println("\nмассив masB");
        System.out.print("masB elements: ");
        for (double v : masB) {
            System.out.printf("%3.0f ", v);
        }
        System.out.println("\n---------------------------------");
*/
        for (int i = 0; i < count; i++) {
            //Если индекс Амассива равен его размеру
            //добавляем оставшиеся элементы из массива Б
            if (masAIndex == masA.length - 1) {
                /*for (int j = masBIndex; j < i - masBIndex; j++) {
                    masResult[i] = masB[j];*/
                if (masBIndex != masB.length - 1) {
                    masResult[i] = masB[masBIndex];
                    masBIndex++;
                    continue;
                }
            }

            //return masResult;


            if (masBIndex == masB.length - 1) {
                /*for (int j = masAIndex; j < i - masAIndex; j++) {
                    //System.out.println("masAindex=" + masAIndex);
                    masResult[i] = masA[j];*/
                if (masAIndex != masA.length - 1) {
                    masResult[i] = masA[masAIndex];
                    masBIndex++;
                    continue;
                }
            }

            // return masResult;


            if (masAIndex < masA.length && masBIndex < masB.length) {
                if (masA[masAIndex] <= masB[masBIndex]) {
                    masResult[i] = masA[masAIndex];
                    masAIndex++;
                } else {
                    masResult[i] = masB[masBIndex];
                    masBIndex++;
                }
            }

                       /* System.out.println("masResult:");
                for (double v : masResult) {
                    System.out.printf("%3.0f ", v);
                }
                System.out.println();*/
            //Если индекс Бмассива равен его размеру
            //добавляем оставшиеся элементы из массива А
        }
        //return masResult;
        return masResult;
    }


}
