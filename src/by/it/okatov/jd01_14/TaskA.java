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
        readToArrayList(fileName, arrList, sum);

        //Создает новый файл и записывает в него все числа из старого через
        // пробел, добавляя строку с подсчетом среднего арифметического этих чисел
        simpleName = "resultTaskA.txt";
        writeInputToFile(getFileName(TaskA.class, simpleName), arrList, sum);
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
                output.writeInt((int) (Math.random() * 10));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readToArrayList(String fileName, List<Integer> arrList, double sum) {
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

            //Печатает список в консоль
            printList(arrList, sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printList(List<Integer> arrList, double sum) {
        for (Integer i : arrList) {
            System.out.printf("%d ", i);
            sum += i;
        }
        //DecimalFormat dc = new DecimalFormat("#.########E##");
        //String output = dc.format(sum / arrList.size());
        //System.out.println(output);
        System.out.printf("%navg=%f", sum / arrList.size());
    }

    private static void writeInputToFile(String fileName, List<Integer> arrList, double sum) {
        try (PrintWriter print = new PrintWriter(fileName)) {
            for (Integer i : arrList) {
                print.printf("%d ", i);
                sum += i;
            }
            print.printf("%navg=%e", sum / arrList.size());
        } catch (FileNotFoundException e) {
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
