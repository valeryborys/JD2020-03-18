package by.it.verbitsky.jd01_04;

import static by.it.verbitsky.jd01_04.TaskA.printArray;

public class TaskC {
    public static void main(String[] args) {
        String line = "5 6 3 2 1 9 8 7 4";
        buildOneDimArray(line);
    }

    static void buildOneDimArray(String line) {
        line = line.trim();
        String[] stringDobles = line.split(" ");
        double[] arr = new double[stringDobles.length];
        for (int i = 0; i < stringDobles.length; i++) {
            if (!stringDobles[i].equals(" "))
                arr[i] = Double.parseDouble(stringDobles[i]);
        }

        double first = arr[0];
        double last = arr[arr.length - 1];
        mergeSort(arr);

        printArray(arr, "V", 4);
        int firstIndex = binarySearch(arr, first);
        int lasttIndex = binarySearch(arr, last);

        System.out.println("Index of first element=" + firstIndex);
        System.out.println("Index of last element=" + lasttIndex);

    }

    static void mergeSort(double[] arr) {
        if (arr.length < 2) return; //если длина меньше 2 (т.е. 1) значит деление прекращаем и выходим из рекурсии
        int m = arr.length / 2; //середина массива чтобы делить пополам
        //массивы для деления
        double[] arr1 = new double[m];
        double[] arr2 = new double[arr.length - m];
        //копируем ссылки на элементы базового массива по индексам от 0 до середины
        System.arraycopy(arr, 0, arr1, 0, arr1.length);
        //копируем ссылки на элементы базового массива по индексам от середины до конца
        System.arraycopy(arr, m, arr2, 0, arr.length - m);
        //делим массивы до тех пор пока не дойдем до размерности 1
        mergeSort(arr1);
        mergeSort(arr2);
        //делаем результирующий массив, в котороый смержим отсортированные части
        double[] res = merge(arr1, arr2);
        //заменяем исходный массив элементами отсортированного массива
        System.arraycopy(res, 0, arr, 0, arr.length);
    }

    static double[] merge(double[] masA, double[] masB) {
        int n = masA.length + masB.length;
        double[] arr = new double[n];
        int masAIndex = 0; //курсор левый массив
        int masBIndex = 0; //курсор правый массив
        for (int i = 0; i < n; i++) {
            //Если левый массив уже закончился - добираем элементы из правого
            if (masAIndex == masA.length) {
                arr[i] = masB[masBIndex];
                masBIndex++;
                // Если левый массив уже закончился - добираем элементы из правого
            } else if (masBIndex == masB.length) {
                arr[i] = masA[masAIndex];
                masAIndex++;
            } else {
                if (masA[masAIndex] < masB[masBIndex]) {
                    arr[i] = masA[masAIndex];
                    masAIndex++;
                } else {
                    arr[i] = masB[masBIndex];
                    masBIndex++;
                }
            }
        }
        return arr;
    }

    static int binarySearch(double[] array, double value) {
        int l = 0;
        int r = array.length - 1;
        int m;
        while (l <= r) {
            if ((r - l) < 2) {
                //значит осталось 2 эемента
                if (array[l] == value) {
                    return l;
                }
                if (array[r] == value)
                    return r;
            }
            m = (r + l) / 2;

            if (array[m] == value) {
                return m;
            } else if (array[m] < value) {
                l = m + 1;
            } else if (array[m] > value) {
                r = m - 1;
            }
        }
        System.out.println("Искомый элемент не найден");
        return -1;
    }
}
