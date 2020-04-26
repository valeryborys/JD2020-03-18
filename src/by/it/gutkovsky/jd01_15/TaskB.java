package by.it.gutkovsky.jd01_15;

import java.io.*;

class TaskB {
    public static void main(String[] args) {
        //creating var
        StringBuilder text = new StringBuilder();
        //getFileName
        String path = getFileName(TaskBrevFirst.class, "TaskB.txt");
        /* get file from which we will read data
         *
         *
         */
        String sourceFile = getFileName(TaskBrevFirst.class, "TaskB.java");
        /* ReadFromFile
         */
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {

            while (reader.ready()) {
                text.append(reader.readLine());
                text.append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        int ind1 = 0;
        int ind2 = 0;
        boolean canDelete = true;

        while(canDelete){
            if(text.indexOf("//",ind1)>0){
               ind1 = text.indexOf("//",ind1);
               ind2 = text.indexOf("\n", ind1);
               text.delete(ind1, ind2);
               continue;
            }
            while (text.indexOf("//",ind1)>0){
                ind1 = text.indexOf("//",ind1);
                ind2 = text.indexOf("\n", ind1);
                text.delete(ind1, ind2);
            }
            canDelete=false;
        }

        ind1 = 0;
        canDelete = true;
        while(canDelete){
            if(text.indexOf("/*",ind1)>0){
                ind1 = text.indexOf("/*",ind1);
                ind2 = text.indexOf("*/", ind1);
                text.delete(ind1, (ind2+2));
                continue;
            }
            canDelete=false;
        }

        writeToFile(text, path);

        System.out.println(text);
    }

    /**
     * This method writes data into a file
     *
     * @param path - path to the file to which it is necessary to save the data
     * @param text - source from which will be data read
     */
    private static void writeToFile(StringBuilder text, String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(String.valueOf(text));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFileName(Class<?> aClass, String fileName) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        path = path + aClass.getName().replace(".", File.separator);
        path = path.replace(aClass.getSimpleName(), fileName);
        return path;
    }
}
