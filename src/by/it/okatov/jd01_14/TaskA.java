package by.it.okatov.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TaskA {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        String simpleName = "dataTaskA.bin";
        String fileName = getFileName(TaskA.class, simpleName);
        List<Integer> arrList = new ArrayList<>();
        double sum = 0.0;

        //Записывает в файл 20 случайных целых чисел
        writeInFile(fileName);

        //Читает содержимое файла и записывает его в ArrayList
        // после чего выводит в консоль и считает среднее из всех чисел
        arrList = readToArrayList(fileName);

        printList(arrList);
        //Создает новый файл и записывает в него все числа из старого через
        // пробел, добавляя строку с подсчетом среднего арифметического этих чисел
        simpleName = "resultTaskA.txt";
        writeInputToFile(getFileName(TaskA.class, simpleName), arrList);
    }

    static String getFileName(Class<?> aClass, String simpleName) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        path += aClass.getName()
                        .replace(".", File.separator)
                        .replace(aClass.getSimpleName(), "")
                        + simpleName;
        return path;
    }

    private static void printList(List<Integer> arrList) {
        double sum = 0;
        for (Integer i : arrList) {
            sum += i;
            System.out.printf("%d ", i);
        }
        System.out.printf("\navg=%f\n", sum / arrList.size());
    }

    private static List<Integer> readToArrayList(String filename) {
        List<Integer> arrList;
        try (DataInputStream input =
                     new DataInputStream(
                             new BufferedInputStream(
                                     new FileInputStream(filename)
                             )
                     )
        ) {
            arrList = new ArrayList<>();
            while (input.available() > 0) {
                arrList.add(input.readInt());
            }

            //Печатает список в консоль
            //printList(arrList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return arrList;
    }

    private static void writeInFile(String filename) {
        try (DataOutputStream output =
                     new DataOutputStream(
                             new BufferedOutputStream(
                                     new FileOutputStream(filename)
                             )
                     )
        ) {
            for (int i = 0; i < 20; i++) {
                output.writeInt((int) (Math.random() * 10));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeInputToFile(String fileName, List<Integer> arrList) {
        try (PrintWriter print = new PrintWriter(fileName)) {
            double sum = 0;
            for (Integer i : arrList) {
                print.printf("%d ", i);
                sum += i;
            }
            print.printf("%navg=%f", sum / arrList.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
