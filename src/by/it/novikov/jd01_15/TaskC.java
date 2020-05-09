package by.it.novikov.jd01_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

class TaskC {

    private static String myPointName = Helper.getPath("TaskC.java", TaskC.class);
    private static Path myPointPath = Paths.get(myPointName).getParent();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вы находитесь здесь:" + myPointPath);
        String scannedText;
        while (true) {
            scannedText = scanner.nextLine();
            if (scannedText == null || scannedText.equals("end")) {
                break;
            } else {
                proceed(scannedText);
            }
        }
    }

    private static void proceed(String scannedText) {
        switch (scannedText) {
            case "cd ..": {
                goBackFromFolder();
                break;
            }
            case "dir": {
                printDirectionContent();
                break;
            }
            default: {
                if (scannedText.matches("cd [-_a-zA-Zа-яА-ЯёЁ0-9]+")) {
                    chooseCatalog(scannedText);
                } else {
                    System.out.println("Такой команды не найдено:(");
                    break;
                }
            }
        }
    }

    private static void goBackFromFolder() {
        System.out.println("Вы вышли из папки");
        myPointPath = myPointPath.getParent();
        myPointName = myPointPath.toString();
        System.out.println(myPointPath);
    }

    private static void printDirectionContent() {
        File file = new File(myPointPath.toString());
        if (file.isDirectory()) {
            System.out.println("Это папка " + file);
            System.out.println("Список файлов:");
        } else {
            System.out.println("Это не папка");
        }
        File[] files = file.listFiles();
        printFilesAndCatalogs(files);
    }

    private static void chooseCatalog(String s) {
        String newFolder = s
                .replace(" ", "")
                .substring(2, s.length() - 1);
        System.out.println("Выбран католог " + newFolder);
        myPointName = myPointName + File.separator + newFolder;
        myPointPath = Paths.get(myPointName);
        System.out.println(myPointPath);
    }

    private static void printFilesAndCatalogs(File[] directory) {
        try {
            for (File file : directory) {
                if (file.isDirectory()) {
                    String path = file.getPath();
                    Object date = Files.getAttribute(Paths.get(path), "basic:creationTime");
                    String dateOfCreation = date.toString();
                    String dir = "<DIR>";
                    System.out.printf("%-28s %9s %-20s\n", dateOfCreation, dir, file.getName());
                    printFilesAndCatalogs(file.listFiles());
                } else {
                    String path = file.getPath();
                    Object date = Files.getAttribute(Paths.get(path), "basic:creationTime");
                    String d = date.toString();
                    System.out.printf("%-28s           %-20s\n", d, file.getName());
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Список пуст");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}