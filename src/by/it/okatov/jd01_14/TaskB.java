package by.it.okatov.jd01_14;

import java.io.*;

public class TaskB {
    public static void main(String[] args) {

        String text;
        String path = TaskA.getFileName(TaskB.class, "text.txt");
        int bytes = 0;
        int punctCounter = 0;

        //Прочитать текст из файла
        text = readFromFile(path);
        //Найти количество знаков пунктуации
        punctCounter = getPunctCounter(text);
        //Разбить текст на отдельные слова, чтобы найти их количество
        String[] arr = getWordsCount(text);
        //Напечатать количество знаков пунктуации и слов в консоль
        printCountersToConsole(punctCounter, arr);
        //Записать количество знаков пунктуации и слов в консоль в файл
        writeDataToFile(punctCounter, arr);
    }

    /***
     * Читает текст из файла и заменяет в нем троеточие на одну точку
     * @param path - путь к файлу для чтения
     * @return текст из файла в строке
     */
    private static String readFromFile(String path) {
        StringBuilder sbText = new StringBuilder();
        int bytes;
        String text;
        try (FileReader fr = new FileReader(new File(path))) {
            while ((bytes = fr.read()) != -1)//Пока есть что читать
            {
                sbText.append((char) bytes);
            }
            text = sbText.toString().replace("...", ".");
            return text;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * Печатает количество знаков пунктуации и слов в тексте в консоль
     * @param punctCounter количество знаков пунктуации
     * @param arr количество слов в тексте
     */
    private static void printCountersToConsole(int punctCounter, String[] arr) {
        System.out.println("\n");
        System.out.println("punctuation marks=" + punctCounter);
        System.out.println("words=" + arr.length);

    }

    /***
     * Подсчитывает количество слов в тексте
     * @param text входной текст
     * @return количество слов в тексте
     */
    private static String[] getWordsCount(String text) {
        return text
                       .replaceAll("[-,\\.!?:]", "")
                       .replace("  ", " ")
                       .replace('\n', ' ')
                       .split(" ");
    }

    /***
     * Находит знаки пунктуации в тексте
     * @param text входной текст
     * @return количество знаков пуктуации
     */
    private static int getPunctCounter(String text) {
        int punctCounter = 0;
        for (char c : text.toCharArray()) {
            if (!Character.isLetterOrDigit(c))//Если знак не число и не цифра
            {
                //Если знак не разделительный символ (пробел, табуляция, перевод строки/каретки)
                if (!Character.isWhitespace(c)) {
                    punctCounter++;
                    System.out.print(c);
                }
            }
        }
        return punctCounter;
    }

    /***
     * Записывает количество знаков пунктуации и количество слов в файл
     * @param punctCounter количество знаков пунктуации
     * @param arr массив всех слов
     */
    private static void writeDataToFile(int punctCounter, String[] arr) {
        try (PrintWriter print = new PrintWriter(TaskA.getFileName(TaskB.class, "resultTaskB.txt"))) {
            print.println("punctuation marks=" + punctCounter);
            print.println("words=" + arr.length);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}
