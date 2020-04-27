package by.it.verbitsky.jd01_14;

import java.io.*;

class TaskB {
    private static final String inputFileName = "TaskB.txt";
    private static final String outputFileName = "resultTaskB.txt";

    public static void main(String[] args) {
        int wordsCount = getWordsCountFromFile(getFullPath(TaskB.class, inputFileName));
        int punctsCount = getPunctsCount(getFullPath(TaskB.class, inputFileName));
        printConsole(wordsCount, punctsCount);
        writeTextFile(getFullPath(TaskB.class, outputFileName), wordsCount, punctsCount);

    }

    private static void writeTextFile(String fname, int wordsCount, int punctsCount) {
        try (PrintWriter writer = new PrintWriter(fname)) {
            writer.printf("words=%d, punctuation marks=%d", wordsCount, punctsCount);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printConsole(int wordsCount, int punctsCount) {
        System.out.printf("words=%d, punctuation marks=%d", wordsCount, punctsCount);
    }

    private static int getPunctsCount(String fName) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fName))) {
            while (reader.ready()) {
                text.append(reader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] strings = text.toString().replaceAll("\n", " ").split("[^,!.-]+");
        return strings.length;
    }

    private static int getWordsCountFromFile(String fName) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fName))) {
            while (reader.ready()) {
                text.append(reader.readLine()).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] strings = text.toString().replaceAll("\n", " ").split("\\s\\b");
        return strings.length;
    }

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
}
