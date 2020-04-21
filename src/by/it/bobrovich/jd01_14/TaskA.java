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
                            new FileOutputStream(dir(TaskA.class)))
            );
            for (int i = 0; i < 20; i++) {
                dos.write((int) (Math.random() * 20));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
    }
}
