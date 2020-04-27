package by.it.szamostyanin.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    private static String getFileName(Class<?> aClass, String aName) {
        String path = aClass.getName().replace(".", "\\");
        String root = System.getProperty("user.dir") + "\\" + "src" + File.separator;   //File.separator - "\" в windows
        path = path.replace(aClass.getSimpleName(), "");
        return root + path + aName;
    }

    public static void main(String[] args) throws RuntimeException {
        //Locale.setDefault(Locale.ENGLISH);        //определение языка
        String filename = getFileName(TaskA.class, "dataTaskA.bin");
        writeInt(filename);
        List<Integer> List = readInt(filename);
        consoleInt(List);
        consoleTxt(List);
    }

    private static void writeInt(String filename) {
        try (DataOutputStream dOS = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))) {
            for (int i = 0; i < 20; i++) {
                dOS.writeInt((int) (Math.random() * 1000));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void consoleTxt(List<Integer> list) {
        String filename;
        filename = getFileName(TaskA.class, "resultTaskA.txt");
        try (PrintWriter out = new PrintWriter(filename)) {
            double sum2 = 0;
            for (Integer i : list) {
                sum2 += i;
                out.printf("%d ", i);
            }
            out.printf("\navg=%f\n", sum2 / list.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void consoleInt(List<Integer> list) {
        double sum1 = 0;
        for (Integer i : list) {
            sum1 += i;
            System.out.printf("%d ", i);
        }
        System.out.printf("\navg=%f\n", sum1 / list.size());
    }

    private static List<Integer> readInt(String filename) {
        List<Integer> List;
        try (DataInputStream dIS = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)))) {
            List = new ArrayList<>();
            while (dIS.available() > 0) {
                List.add(dIS.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return List;
    }
}