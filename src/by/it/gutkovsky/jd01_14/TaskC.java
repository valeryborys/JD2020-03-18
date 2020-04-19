package by.it.gutkovsky.jd01_14;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

class TaskC {
    public static void main(String[] args) {
        String pathToDir = getPathToDirectory("jd01_14");
        File folder = new File(pathToDir);
        File[] content = folder.listFiles(); // массив из всего, что находится в папке gutkovsky (папки jd01_01 - jd01_14 + Main)
        List<String> fileRegistrationList = new ArrayList<>();
        List<String> directoryRegistrationList = new ArrayList<>();

        if (content != null) {
            for (File file : content) {
                if (file.isFile()) {
                    fileRegistration(file, fileRegistrationList);
                } else if (file.isDirectory()) {
                    directoryRegistration(file, fileRegistrationList, directoryRegistrationList);
                }
            }
        }

        printToConsole(fileRegistrationList, directoryRegistrationList);
        String fileName = getFileNameForWriting(TaskC.class, "resultTaskC.txt");
        printToFileTxt(fileRegistrationList, directoryRegistrationList, fileName);

    }

    private static String getPathToDirectory(String folderName) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        path = path + TaskC.class.getPackage().getName().replace(".", File.separator);

        // TaskC.class.getSimpleName() -> TaskC
        // TaskC.class.getName() -> by.it.gutkovsky.jd01_14.TaskC
        // TaskC.class.getPackage().getName() -> by.it.gutkovsky.jd01_14
        // System.out.println(pathToDir); // D:\gutkovsky\JD2020-03-18\src\by\it\gutkovsky\

        return path.replace(folderName, "");
    }

    private static String getFileNameForWriting(Class<?> aCalss, String simpleName) {
        String fileRoot = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        fileRoot = fileRoot + aCalss.getName().replace(".", File.separator);
        fileRoot = fileRoot.replace(TaskC.class.getSimpleName(), "");
        return fileRoot + simpleName;
    }

    private static void printToFileTxt(List<String> fileRegistrationList, List<String> directoryRegistrationList, String fileName) {
        try (PrintWriter out = new PrintWriter(fileName)) {
            for (String resultFile : fileRegistrationList) {
                out.printf("file:%s\n", resultFile); // print all files
            }
            for (String s : directoryRegistrationList) {
                out.printf("dir:%s\n", s); //print all directories
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printToConsole(List<String> fileRegistrationList, List<String> directoryRegistration) {
        // print all files
        for (String resultFile : fileRegistrationList) {
            System.out.printf("file:%s\n", resultFile);
        }
        //print all directories
        for (String s : directoryRegistration) {
            System.out.printf("dir:%s\n", s);
        }
    }

    private static void fileRegistration(File file, List<String> fileRegistrationList) {
        fileRegistrationList.add(file.getName());
    }

    private static void directoryRegistration(File content, List<String> fileRegistrationList, List<String> directoryRegistration) {
        directoryRegistration.add(content.getName());
        File[] subfolders = content.listFiles(); // массив из того, что находится внутри папки
//        if (subfolders.length > 1) {
        if (subfolders != null) {
            for (File subfolder : subfolders) {
                if (subfolder.isFile()) {
                    fileRegistration(subfolder, fileRegistrationList);
                }
                if (subfolder.isDirectory()) {
                    directoryRegistration(subfolder, fileRegistrationList, directoryRegistration);
                }
            }
        }
    }

}


