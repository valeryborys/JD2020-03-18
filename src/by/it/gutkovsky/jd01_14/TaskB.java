package by.it.gutkovsky.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class TaskB {
    public static void main(String[] args) {
        String file = getFileName(TaskB.class,"text.txt");
        List<Integer> wordsCount = new ArrayList<>();
        //readWordsFromTxtFile
        try(FileReader fileReader = new FileReader(file)){
            int sumOfWords = 0;


        } catch (IOException e) {
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
