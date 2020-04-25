package by.it.gutkovsky.jd01_15;

import java.io.File;

class Commands {
    private static String root = System.getProperty("user.dir") + File.separator + "src" + File.separator;
    static String path = root + TaskC.class.getPackage().getName().replace(".", File.separator);

    static String getNewDirectory(String input) {
        String[] folder = input.split(" ");
        path = path + folder[1] + File.separator;
        return path;
    }

    static void printDirProperties(String path) {
        File folder = new File(path);
        File[] content = folder.listFiles();
        String name = null;
        if (content != null) {
            for (int i = 0; i < content.length; i++) {
                if (content[i].isDirectory()) {
                    name = "<DIR>";
                }
                System.out.printf("\t%-10s\t%-10s\n", name, content[i].getName());
            }
        }
    }

    static String getNewDirectory() {
        path = path.substring(0, path.length() - 1);
        int index = path.lastIndexOf('\\');
        path = path.substring(0, index) + File.separator;
        return path;
    }
}
