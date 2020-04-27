package by.it.tolstik.jd01_14;

import java.io.*;

class TaskA {

    public static void main(String[] args) {
        randomOutput();
        randomInput();
    }

    private static String dir(Class<?> aClass) {
        String path = System.getProperty("user.dir") + File.separator
                + "src" + File.separator;
        String cDir = aClass.getName().replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
        return path + cDir;
    }

    private static void randomInput() {
        try (DataInputStream dis = new DataInputStream
                (new BufferedInputStream
                        (new FileInputStream(dir(TaskA.class) + "dataTaskA.bin")));
             PrintWriter pw = new PrintWriter
                     (new FileWriter(dir(TaskA.class) + "resultTaskA.txt"))
        ) {
            double sum = 0;
            double count = 0;
            while (dis.available() > 0) {
                int i = dis.readInt();
                System.out.print(i + " ");
                sum += i;
                count++;
            }
            System.out.println();
            System.out.println("avg=" + sum / count);
            pw.println("avg=" + sum / count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void randomOutput() {
        try (DataOutputStream dos = new DataOutputStream
                (new BufferedOutputStream
                        (new FileOutputStream(dir(TaskA.class) + "dataTaskA.bin")))) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 10000));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
