package by.it.gutkovsky.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TaskB {
    public static void main(String[] args) {
        String file = getFileName(TaskB.class, "text.txt");
        List<String> listOfWords = new ArrayList<>();

        File f = new File(file);
        //readWordsFromTxtFile
        try (final Scanner sc = new Scanner(f)) {
            sc.useDelimiter("\\s+(-\\s)?");
            while (sc.hasNext()) {
                listOfWords.add(sc.next());
            }
//            System.out.println("words=" + (listOfWords.size()));
//            for (int i = 0; i < listOfWords.size(); i++) {
//                System.out.println(listOfWords.get(i));
////                System.out.println();
//            }
        } catch (RuntimeException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
//
        List<String> listOfMarks = new ArrayList<>();

        //readMarksFromTxtFile
        try (final Scanner sc = new Scanner(f)) {
            sc.useDelimiter("[^(а-яА-ЯёЁ)+\\s]");
            while (sc.hasNext()) {
                listOfMarks.add(sc.next());
            }
//            System.out.println("marks=" + (listOfMarks.size()));
//            for (int i = 0; i < listOfMarks.size(); i++) {
//                System.out.println(listOfMarks.get(i));
////                System.out.println();
//            }
        } catch (RuntimeException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String fileToPrint =getFileName(TaskB.class, "resultTaskB.txt");

        //printToConsole
        System.out.println(" words="+listOfWords.size()+", punctuation marks="+(listOfMarks.size()-2));
//        System.out.println(" words="+listOfWords.size()+", marks="+listOfMarks.size());

        //printToFile
        try (PrintWriter out = new PrintWriter(fileToPrint)){
            out.print(" words="+listOfWords.size()+", punctuation marks="+(listOfMarks.size()-2));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    private static String getFileName(Class<?> aClass, String simpleName) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        path = path + aClass.getName().replace(".", File.separator);
        path = path.replace(aClass.getSimpleName(), "");
        return path + simpleName;
    }
}
