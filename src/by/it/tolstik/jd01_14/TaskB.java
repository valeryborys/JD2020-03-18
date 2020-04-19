package by.it.tolstik.jd01_14;

import java.io.*;
import java.util.Scanner;

class TaskB {

    private static String dir(Class<?> aClass) {
        String path = System.getProperty("user.dir") + File.separator
                + "src" + File.separator;
        String cDir = aClass.getName()
                .replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
        return path + cDir;
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner
                (new FileReader(dir(TaskB.class) + "text.txt"));
             PrintWriter pw = new PrintWriter
                     (new FileWriter(dir(TaskB.class) + "resultTaskB.txt"))
        ) {
            StringBuilder text = new StringBuilder();
            while (sc.hasNext()) {
                text.append(sc.nextLine()).append("\n");
            }
            String[] words = text.toString().split("[^а-яА-ЯёЁ]+");
            String[] punctuations = text.toString()
                    .replace(" ", "")
                    .split("[^,!.-]+");
            System.out.printf("words=%d, punctuation marks=%d \n", words.length, punctuations.length);
            pw.printf("words=%d, punctuation marks=%d \n", words.length, punctuations.length);
        } catch (IOException e) {
            System.err.println("Ошибка! " + e);;
        }
    }
}
