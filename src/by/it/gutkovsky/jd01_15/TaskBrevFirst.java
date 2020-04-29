package by.it.gutkovsky.jd01_15;


import java.io.*;
import java.util.*;

class TaskBrevFirst {
    public static void main(String[] args) {
        //creating var
        StringBuilder text = new StringBuilder();
        //getFileName
        String path = getFileName(TaskBrevFirst.class, "TaskBrevFirst.txt");
        /* get file from which we will read data
        *
        *
        */
        String sourceFile = getFileName(TaskBrevFirst.class, "TaskBrevFirst.java");
        /* ReadFromFile
         */
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {

            while (reader.ready()) {
                text.append(reader.readLine());
                text.append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String resultText = String.valueOf(text);
        String[] arrayText = resultText.split("\n");

        boolean multiLineComment = false;
        boolean oneLineComment = false;
        StringBuilder result = new StringBuilder();
        StringBuilder result2 = new StringBuilder();

        Set<Integer> listofComments = new HashSet<>();


        for (int i = 0; i < arrayText.length; i++) {
            char[] chars = arrayText[i].toCharArray();
            oneLineComment = false;
            for (int j = 0; j < chars.length; j++) {
                if (j < chars.length - 1) {
                    if (chars[j] == '/' && chars[j + 1] == '/') {
                        oneLineComment = true;
                        listofComments.add(i);
                        j = chars.length;
                    }

                    if ( j != chars.length && chars[j] == '/' && chars[j + 1] == '*') {
                        multiLineComment = true;
                        listofComments.add(i);
                        j = chars.length;

                    }

                    if (multiLineComment == true) {
                        if (j != chars.length && chars[j] == '*' && chars[j+1] == '/') {
                            multiLineComment = false;
                            j = chars.length;
                        } else  result.append("");

                        listofComments.add(i);
                    }
                }

                if (j!=chars.length && oneLineComment == false && multiLineComment == false) result.append(chars[j]);
//                oneLineComment = false;
            }
            result.append("\n");
        }

//        System.out.println(listofComments.toString());

        for (int i = 0; i < arrayText.length; i++) {
            if (!listofComments.contains(i)){
                result2.append(arrayText[i]).append("\n");
            }
            else {
                char[] element = arrayText[i].toCharArray();
                for (int j = 0; j < element.length; j++) {
                    result2.append("");
                }
            }

        }

        writeToFile(result, path);

        System.out.println(result);
    }

    /**
     * This method writes data into a file
     *
     * @param path - path to the file to which it is necessary to save the data
     * @param text - source from which will be data read
     */
    private static void writeToFile(StringBuilder text, String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(String.valueOf(text));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFileName(Class<?> aClass, String fileName) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        path = path + aClass.getName().replace(".", File.separator);
        path = path.replace(aClass.getSimpleName(), fileName);
        return path;
    }
}
