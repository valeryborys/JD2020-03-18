package by.it.tolstik.jd01_15;

import java.io.*;
import java.util.Random;

class TaskA {

    static String fileName = "matrix.txt";

    public static void main(String[] args) {

        try (PrintWriter pw = new PrintWriter
                (new FileWriter(dir(TaskA.class) + fileName));
             BufferedReader br = new BufferedReader
                     (new FileReader(dir(TaskA.class) + fileName))
        )

        {
            Random random = new Random();
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 4; j++) {
                    int result = random.nextInt(31) - 15;
                    pw.printf("%3d ", result);
                }
                pw.write("\n");
            }
            pw.close();

            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }


        }
        catch(IOException e){
            e.getStackTrace();
        }
    }

    private static String dir(Class<?> aClass) {
        String path = System.getProperty("user.dir") + File.separator
                + "src" + File.separator;
        String cDir = aClass.getName().replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
        return path + cDir;
    }
}
