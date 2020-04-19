package by.it.gutkovsky.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class TaskA {

    private static String getFileName(Class<?> aClass, String simpleName) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        path = path + aClass.getName().replace(".", File.separator);
        path = path.replace(aClass.getSimpleName(), "");
        return path + simpleName;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        String binFileName = getFileName(TaskA.class, "dataTaskA.bin");
        String txtFileName=getFileName(TaskA.class,"resultTaskA.txt");
        //writeBinary
        writeBinary(binFileName);
        //readBinary
        List<Integer> list =readBinary(binFileName);
        //printConsole
        printConsole(list);
        //printToFile
        printToFile(txtFileName, list);


    }

    private static void printToFile(String fileName, List<Integer> list) {
        try (PrintWriter out = new PrintWriter(fileName)){
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

    private static List<Integer> readBinary(String fileName) {
        List<Integer> list;
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(fileName)
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

    private static void writeBinary(String fileName) {
        try (
                DataOutputStream dos = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(fileName)
                        )
                )
        ) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 100));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
