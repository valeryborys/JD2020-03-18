package by.it.okatov.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

public class TaskC {
    public static void main(String[] args) {
        Map<String, String[]> hMap = new HashMap<>();
        String path = TaskA.getFileName(TaskC.class, "");
        File f = new File(path);
        System.out.println(f.getAbsolutePath());
        if (f.isDirectory()) {
            f = new File(f.getParent());
            System.out.println(f.getAbsolutePath());
        }
        //Пишем в консоль и записываем в карту пути
        hMap = consoleMapWrite(hMap, f);
        //Пишем из карты в файл
        fileWrite(hMap);


    }

    /***
     * Сортирует карту по значениям ключей и записывает это в текстовый файл
     * @param hMap карта, содержащая директории в качестве ключей
     *             и массивы файлов в этих директориях в качестве значений
     */
    private static void fileWrite(Map<String, String[]> hMap) {
        Stream<Map.Entry<String, String[]>> stream = hMap.entrySet().stream();
        Stream<Map.Entry<String, String[]>> sorted = stream.sorted(Map.Entry.comparingByKey());
        Iterator<Map.Entry<String, String[]>> it = sorted.iterator();

        try (PrintWriter print = new PrintWriter(TaskA.getFileName(TaskC.class, "resultTaskC.txt"))) {
            while (it.hasNext()) {
                Map.Entry<String, String[]> next = it.next();
                String key = next.getKey();
                String[] val = next.getValue();

                print.println("dir:" + key);
                for (String s : val) {
                    if (s == null)
                        break;
                    print.println("   file:" + s);
                }
            }

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    /***
     * Выводит на экран папки, подпапки и файлы в них, а также записывает эту информацию в хеш-карту
     * @param hMap хеш-карта для сохранения папок и файлов
     * @param rootDirectory корневая директория, по которой осуществляется поиск папок и подпапок
     * @return возвращает карту, заполненную значениями.
     */
    private static Map<String, String[]> consoleMapWrite(Map<String, String[]> hMap, File rootDirectory) {
        int j = 0;
        File subDir;
        String[] sFiles;
        try {
            for (String s : rootDirectory.list()) {
                subDir = new File(rootDirectory.getAbsolutePath() + File.separator + s);
                sFiles = new String[20];
                System.out.println("dir:" + s);
                //findSubFiles
                for (int i = 0; i < subDir.listFiles().length; i++) {
                    if (subDir.listFiles()[i].isDirectory()) //Если находим вложенную директорию
                    {
                        System.out.println("   dir:" + subDir.listFiles()[i].getName());
                        //Создаем указатель на вложенную директорию
                        subDir = new File(subDir.listFiles()[i].getAbsolutePath());
                        String[] tmp = new String[10];
                        for (File file : subDir.listFiles()) {
                            System.out.println("      file:" + file.getName());
                            tmp[j] = file.getName();
                            j++;
                        }
                        //Возвращаем указатель обратно на родительскую директорию
                        subDir = new File(rootDirectory.getAbsolutePath() + File.separator + s);
                        hMap.put(subDir.listFiles()[i].getName(), tmp);
                        continue;
                    }
                    sFiles[i] = subDir.listFiles()[i].getName();
                    System.out.println("   file:" + sFiles[i]);

                }
                hMap.put(s, sFiles);
            }
        } catch (NullPointerException ex) {
            throw new RuntimeException(ex);
        }

        return hMap;
    }
}
