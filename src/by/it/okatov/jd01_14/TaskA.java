package by.it.okatov.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {
        String simpleName = "dataTaskA.bin";
        String fileName = getFileName(TaskA.class, simpleName);
        List<Integer> arrList = new ArrayList<>();
        double sum = 0.0;

        //Записывает в файл 20 случайных целых чисел
        writeInFile(fileName);

        //Читает содержимое файла и записывает его в ArrayList
        // после чего выводит в консоль и считает среднее из всех чисел
        sum = readToArrayList(fileName, arrList, sum);

        //Создает новый файл и записывает в него все числа из старого через
        // пробел, добавляя строку с подсчетом среднего арифметического этих чисел
        simpleName = "resultTaskA.txt";
        writeInputToFile(getFileName(TaskA.class, simpleName), arrList, sum);
    }

    private static void writeInputToFile(String fileName, List<Integer> arrList, double sum) {
        try (PrintWriter print = new PrintWriter(fileName)) {
            for (Integer i : arrList) {
                print.printf("%d ", i);
                sum += i;
            }
            print.printf("%navg=%f", sum / arrList.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static double readToArrayList(String fileName, List<Integer> arrList, double sum) {
        try (DataInputStream input =
                     new DataInputStream(
                             new BufferedInputStream(
                                     new FileInputStream(fileName)
                             )
                     )
        ) {
            while (input.available() > 0) {
                arrList.add(input.readInt());
            }

            //printList
            for (Integer i : arrList) {
                System.out.printf("%d ", i);
                sum += i;
            }
            System.out.printf("%navg=%f", sum / arrList.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sum;
    }

    private static void writeInFile(String fileName) {
        try (DataOutputStream output =
                     new DataOutputStream(
                             new BufferedOutputStream(
                                     new FileOutputStream(fileName)
                             )
                     )
        ) {
            for (int i = 0; i < 20; i++) {
                output.write((int) (Math.random() * 1000 + i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * Получает путь для создания, записи или чтения файла, находящегося в текущем пакете
     * @param aClass - класс, вызывающий метод
     * @param simpleName - названия файла для чтения/записи
     * @return полный путь к файлу для чтения/записи
     */
    static String getFileName(Class<?> aClass, String simpleName) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        path += aClass.getName()
                        .replace(".", File.separator)
                        .replace(aClass.getSimpleName(), "")
                        + simpleName;
        return path;
    }
}
