package by.it.bobrovich.jd01_14;


import java.io.*;

public class TaskA {

    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clPath = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clPath;
    }

    public static void main(String[] args) {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(dir(TaskA.class) + "dataTaskA.bin"))
            );
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 25));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(dir(TaskA.class) + "dataTaskA.bin")));
             PrintWriter pw = new PrintWriter(new FileWriter(dir(TaskA.class)+"resultTaskA.txt"))
        ) {
            double sum = 0;
            double count = 0;
            while (dis.available() > 0) {
                int i = dis.readInt();
                System.out.print(i + " ");
                pw.print(i + " ");
                sum += i;
                count++;
            }
            System.out.println("\navg=" + sum / count);
            pw.print("\navg=" + sum / count);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
