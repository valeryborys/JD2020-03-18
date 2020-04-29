package by.it.verbitsky.jd01_15;


import java.io.*;

/**
 * Class contains solution of TaskB jd15
 *
 * @author Verbitsky Sergey
 * @version 1.0
 */


class TaskB implements Comments {

    private static final String inputFileName = "TaskB.java";
    private static final String outputFileName = "TaskB.txt";

    public static void main(String[] args) {
        //получаем текст-описание класса из java файла
        String text = readTextFile(getFullPath(TaskB.class, inputFileName));
        //удаляем все комменты
        text = removeComments(text);
        /*  результирующий текст выводим на консоль
         *   и записываем в файл txt
         * */
        printCode(text);
        writeTextFile(getFullPath(TaskB.class, outputFileName), text);

        /*
         test block comments
        */
    }

    private static String removeComments(String text) {

        int startPos = 0; //позиция начала удаления
        int endPos; //позиция понца удаления
        boolean flag = true;
        StringBuilder res = new StringBuilder(text);
        while (flag) {
            try {
                if (res.indexOf(Comments.START_SINGLE_COMMENT, startPos) > 0) {
                    startPos = res.indexOf(Comments.START_SINGLE_COMMENT, startPos);
                    endPos = res.indexOf(END_SINGLE_COMMENT, startPos);
                    res.delete(startPos, endPos);
                    continue;
                }
            } catch (IndexOutOfBoundsException e) {
                throw new RuntimeException(e);
            }
            flag = false;
        }
        startPos = 0; //позиция начала удаления
        endPos = 0; //позиция понца удаления
        flag = true;
        while (flag) {
            try {
                if (res.indexOf(Comments.START_BLOCK_COOMENT, endPos) > 0) {
                    startPos = res.indexOf(Comments.START_BLOCK_COOMENT, startPos);
                    endPos = res.indexOf(Comments.END_BLOCK_COOMENT, startPos) + 2;
                    res.delete(startPos, endPos);
                    endPos += 2;
                    continue;
                }
            } catch (IndexOutOfBoundsException ex) {
                throw new RuntimeException(ex);
            }
            flag = false;
        }
        return res.toString();
    }

    /**
     * @param aClass - needs to get full path to this file
     * @param name   - fileName for creation of new file
     */
    private static String getFullPath(Class<?> aClass, String name) {
        StringBuilder fullPath = new StringBuilder();
        fullPath.append(System.getProperty("user.dir"))
                .append(File.separator)
                .append("src")
                .append(File.separator)
                .append(aClass.getName()
                        .replace('.', File.separatorChar)
                        .replace(aClass.getSimpleName(), ""))
                .append(name);
        return fullPath.toString();
    }

    private static void printCode(String text) {
        String[] lines = text.split("\\n");
        for (String line : lines) {
            System.out.println(line);
        }
    }

    private static String readTextFile(String fileName) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                text.append(reader.readLine()).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return text.toString();
    }

    private static void writeTextFile(String fName, String text) {
        String[] lines = text.split("\\n");
        try (PrintWriter writer = new PrintWriter(fName)) {
            writer.println(text);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
