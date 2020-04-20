package by.it.okatov.jd01_15;

import java.io.*;

public class TaskB {
    public static void main(String[] args) {
        Class<TaskB> aClass = TaskB.class;
        String fullPath = getFileName(aClass, aClass.getSimpleName() + ".java");
        int bytes;
        StringBuilder sb = new StringBuilder();
        //Считываем в StringBuilder весь текст в файле *.java
        readClassFile(fullPath, sb);


        //Удаляем комментарии
        StringBuilder removeComments = removeComments(sb.toString());
        System.out.println(removeComments.toString());

        //Записываем полученный текст без комментариев в файл
        printInTxtFile(aClass, removeComments);
    }

    /***
     * Записывает переданный текст в файл с расширением *.txt
     * @param aClass текущий класс, используемый для получения местоположения файла
     * @param text записываемый в файл текст
     */
    private static void printInTxtFile(Class<TaskB> aClass, StringBuilder text) {
        try (PrintWriter pw = new PrintWriter(getFileName(aClass, aClass.getSimpleName() + ".txt"))) {
            pw.println(text.toString());
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    /***
     * Считывает байты из указанного файла
     * @param fullPath путь к файлу
     * @param sb строитель строк для записи байтов файла
     */
    private static void readClassFile(String fullPath, StringBuilder sb) {
        int bytes;
        try (FileReader reader = new FileReader(fullPath)) {
            while ((bytes = reader.read()) != -1) //Пока есть что читать
            {
                sb.append((char) bytes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * Удаляет блочные, строковые комментарии и записи JavaDoc из файла
     * @param code строка кода, из которой нужно удалить комментарии
     * @return Построенную строку уже без комментариев
     */
    public static StringBuilder removeComments(String code) {
        StringBuilder removedComments = new StringBuilder();

        try (StringReader sr = new StringReader(code)) {
            boolean isBlock = false; //блочный комментарий
            boolean isLine = false; //Строковый комментарий
            boolean isFinish = true;

            int iPrevious = sr.read(); //Предыдущий символ
            int iCurrent;//Текущий символ

            for (iCurrent = sr.read(); iCurrent != -1; iCurrent = sr.read()) {
                if (isBlock) {
                    if (iPrevious == '*' && iCurrent == '/') {
                        isBlock = false;
                        isFinish = false;
                    }
                } else if (isLine) {
                    if (iCurrent == '\r')//Строки в файле .java как правило кончаются на '\r\n'
                    {
                        isLine = false;
                        isFinish = false;
                    }
                } else if (iPrevious == '/' && iCurrent == '*') {
                    isBlock = true;
                } else if (iPrevious == '/' && iCurrent == '/') {
                    isLine = true;
                } else if (isFinish) {
                    removedComments.append((char) iPrevious);
                } else {
                    isFinish = true;
                }

                iPrevious = iCurrent;
            }

            if (iPrevious != -1 && isFinish && !isLine) {
                removedComments.append((char) iPrevious);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return removedComments;
    }


    /***
     * Возвращает путь к создаваемому/читаемому файлу в папке с заданным классом
     * @param aClass заданный класс, от которого находим местоположение файла .java
     * @param fileName новое/искомое имя файла
     * @return полный путь
     */
    public static String getFileName(Class<?> aClass, String fileName) {
        return System.getProperty("user.dir") +
                       File.separator +
                       "src" +
                       File.separator +
                       aClass.getName().replace(".", File.separator).
                                                                            replace(aClass.getSimpleName(), "")
                       + fileName;
    }
}

