package by.it.lemesh.jd01_14;

import java.io.*;
import java.util.ArrayList;

public class TaskA {
    private static String getDir(Class<?> cl, String name) {
        String root = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return root + path + name;
    }

    public static void main(String[] args) {
        String fileName = getDir(TaskA.class, "dataTaskA.bin");
        writeInt(fileName);
        ArrayList<Integer> list = null;
        list = readInt(fileName);
        printConsole(list);
        fileName = getDir(TaskA.class, "resultTaskA.txt");
        writeTxt(fileName, list);
    }

    private static void writeTxt(String fileName, ArrayList<Integer> list) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            double sum2 = 0;
            for (Integer i : list) {
                sum2 += i;
                writer.printf("%d ", i);
            }
            writer.println("\navg=" + sum2 / list.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printConsole(ArrayList<Integer> list) {
        double sum = 0;
        for (Integer i : list) {
            sum += i;
            System.out.printf("%d ", i);
        }
        System.out.println("\navg=" + sum / list.size());
    }

    private static ArrayList<Integer> readInt(String fileName) {
        ArrayList<Integer> list = null;
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            list = new ArrayList<>();
            while (dis.available() > 0) {
                list.add(dis.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static void writeInt(String fileName) {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 100));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
