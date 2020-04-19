package by.it.gutkovsky.jd01_14;

import java.io.*;

class TaskArevOne {
    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String fileDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + fileDir;
    }

    public static void main(String[] args) {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(dir(TaskArevOne.class) + "dataTaskA.bin")));
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 100));
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
        try (DataInputStream inp = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(dir(TaskArevOne.class) + "dataTaskA.bin")));
             PrintWriter out2 = new PrintWriter(new FileWriter(dir(TaskArevOne.class) + "resultTaskA.txt"))
        ) {
            double sum = 0;
            double count = 0;
            while (inp.available() > 0) {
                int i = inp.readInt();
                System.out.print(i + " ");
                out2.print(i + " ");
                sum += i;
                count++;

            }
            System.out.println("\navg=" + sum / count);
            out2.print("\navg=" + sum / count);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
