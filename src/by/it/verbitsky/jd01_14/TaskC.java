package by.it.verbitsky.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

class TaskC {
    private static final String rootFolder = "verbitsky";
    private static final String outputFileName = "resultTaskC.txt";
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        String path = getStartPath(TaskC.class);
        dirFiles(path);
        writeConsole();
        writeTextFile(getFullPath(TaskC.class, outputFileName), list);
    }

    private static void writeConsole() {
        for (String s : list) {
            System.out.print(s);
        }
    }

    //просматриваем папки/файлы
    private static void dirFiles(String path) {
        File file = new File(path);
        //Если file - файл - выводим в консоль
        String name = file.getName();
        if (file.isFile()) {
            list.add(String.format("file:%s\n", name));
        }
        //Если файл - каталог, лезем внутрь рекурсивно
        if (file.isDirectory()) {
            list.add(String.format("dir:%s\n", name));
            File[] fileList = file.listFiles();
            if (fileList.length != 0) {
                for (File everyDir : fileList) {
                    dirFiles(everyDir.getAbsolutePath());
                }
            }
        }
    }

    //получаем стартовую директорию по фамилии
    private static String getStartPath(Class<?> aClass) {
        StringBuilder fullPath = new StringBuilder();
        fullPath.append(System.getProperty("user.dir"))
                .append(File.separator)
                .append("src")
                .append(File.separator)
                .append(aClass.getName()
                        .replace('.', File.separatorChar)
                        .replace(aClass.getSimpleName(), ""));
        fullPath.delete(fullPath.indexOf(rootFolder) + rootFolder.length(), fullPath.length() - 1);
        return fullPath.toString();
    }

    //полчаем полный путь к директории где лежит "запускатор" (для вывода результата в файл)
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

    //пишет результат просмотра в текстовый файл
    private static void writeTextFile(String fName, List<String> list) {
        try (PrintWriter writer = new PrintWriter(fName)) {
            for (String element : list) {
                writer.print(element);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
