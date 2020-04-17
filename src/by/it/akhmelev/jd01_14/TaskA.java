package by.it.akhmelev.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TaskA {
    private static String getFilename(Class<?> aClass, String simpleName) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        path = path + aClass.getName().replace(".", File.separator);
        path = path.replace(aClass.getSimpleName(), "");
        return path + simpleName;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        String binFilename = getFilename(TaskA.class, "dataTaskA.bin");
        String txtFilename = getFilename(TaskA.class, "resultTaskA.txt");

        writeInt(binFilename);
        List<Integer> list = readInt(binFilename);
        printConsole(list);
        printToTxt(txtFilename, list);
    }

    private static void printToTxt(String filename, List<Integer> list) {
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

    private static void printConsole(List<Integer> list) {
        double sum = 0;
        for (Integer i : list) {
            sum += i;
            System.out.printf("%d ", i);
        }
        System.out.printf("\navg=%f\n", sum / list.size());
    }

    private static List<Integer> readInt(String filename) {
        List<Integer> list;
        try (
                DataInputStream dis = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream(filename)
                        )
                )
        ) {
            list = new ArrayList<>();
            while (dis.available() > 0) {
                list.add(dis.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    private static void writeInt(String filename) {
        try (
                DataOutputStream dos = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(filename)
                        )
                )
        ) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 1000));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
