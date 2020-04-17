package by.it.verbitsky.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class TaskA {
    private static final String intFileName = "dataTaskA.bin";
    private static final String textFileName = "resultTaskA.txt";

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        writeIntFile(getFullPath(TaskA.class, intFileName));
        List<Integer> integers = readIntFile(getFullPath(TaskA.class, intFileName));
        printConsole(integers);
        writeTxtFile(getFullPath(TaskA.class, textFileName), integers);
    }

    private static void writeTxtFile(String fName, List<Integer> list) {
        double sum = 0;
        try (PrintWriter writer = new PrintWriter(fName)) {
            for (Integer value : list) {
                writer.printf("%d ", value);
                sum += value;
            }
            writer.printf("\navg=%3.3f\n", sum / list.size());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static void printConsole(List<Integer> integers) {
        double sum = 0;
        for (Integer value : integers) {
            System.out.printf("%d ", value);
            sum += value;
        }
        System.out.printf("\navg=%3.3f\n", sum / integers.size());
    }

    private static List<Integer> readIntFile(String fName) {
        List<Integer> list = new ArrayList<>();
        try (DataInputStream reader =
                     new DataInputStream(
                             new BufferedInputStream(
                                     new FileInputStream(fName)
                             )
                     )
        ) {

            while (reader.available() > 0) {
                list.add(reader.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    private static void writeIntFile(String fName) {
        try (DataOutputStream writer =
                     new DataOutputStream(
                             new BufferedOutputStream(
                                     new FileOutputStream(fName)
                             )
                     )
        ) {
            for (int i = 0; i < 20; i++) {
                writer.writeInt((int) (Math.random() * 100));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

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


}
