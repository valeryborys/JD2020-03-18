package by.it.verbitsky.jd01_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;

class FileManager implements FileManagerCommands, FileManagerStrings {
    private final static String DATE_FORMAT = "d MM yyyy HH:mm";

    private String currentDirectory;
    private FileManagerParser parser;

    public static String getPath(Class<?> aClass) {
        StringBuilder fullPath = new StringBuilder();
        fullPath.append(System.getProperty("user.dir"))
                .append(File.separator)
                .append("src")
                .append(File.separator)
                .append(aClass.getName()
                        .replace('.', File.separatorChar)
                        .replace(aClass.getSimpleName(), ""))
                .delete(fullPath.length() - 1, fullPath.length());
        return fullPath.toString();
    }

    private String getCurrentDirectory() {
        return currentDirectory;
    }

    private void setCurrentDirectory(String path) {
        this.currentDirectory = path;
    }

    private void setParser(FileManagerParser parser) {
        this.parser = parser;
    }

    private FileManagerParser getParser() {
        return parser;
    }

    public FileManager(String path, FileManagerParser parser) {
        setCurrentDirectory(path);
        setParser(parser);
        showCursor();
    }

    private void showCursor() {
        System.out.print(getCurrentDirectory() + ">");
    }

    @Override
    public void changeDir(Command cmd) {
        System.out.println("curr dir=" + getCurrentDirectory());
        System.out.println("command=" + cmd.getCommand());
        System.out.println("arg=" + Arrays.toString(cmd.getArgs()));

        String[] args = cmd.getArgs();

        //Чисто команда cd без ничего
        if (args[0].matches(FileManagerStrings.EMPTY_PATTERN)) {
            System.out.println("empty cd");
            System.out.println(getCurrentDirectory());
            System.out.println();
            showCursor();
            return;
        }

        //Если cd .. - поднимаемся на каталог выше
        if (args[0].matches(FileManagerStrings.DOTS_PATTERN)) {
            System.out.println("cd dots");
            try {
                setCurrentDirectory(new File(getCurrentDirectory()).getParentFile().getAbsolutePath());
                showCursor();
            } catch (Exception e) {
                //throw new NullPointerException(e.getMessage());
                showCursor();
            }
            return;
        }

        String path = args[0];
        //Проверим, если передали полный путь:
        if (args[0].length() > 0) {
            System.out.println("cd full path");
            //Если передали полный путь:
            File file = new File(path);
            if (file.isDirectory()) {
                setCurrentDirectory(path);
                showCursor();
                return;
            }
        }
        //если в аргументе только имя директории - пробуем найти ее в спискее директорий текущего каталога
        System.out.println("cd + dirname");
        File file = new File(getCurrentDirectory());
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                if ((f.getName().trim()).equalsIgnoreCase(path.trim())) {
                    System.out.println("Совпало арг и дирнэйм");
                    setCurrentDirectory(f.getAbsolutePath());
                    showCursor();
                    return;
                }
            }
        }
        System.out.println();
        System.out.println(FileManagerStrings.PATH_NOT_FOUND);
        showCursor();
    }

    @Override
    public void printCurrentDir(Command cmd) {
        System.out.printf("\nСодержимое папки %s\n\n", this.currentDirectory);
        File f = new File(this.currentDirectory);
        int fileCount = 0;
        int dirCount = 0;
        Long totalFileSize = 0L;
        for (File element : f.listFiles()) {
            if (element.isFile()) {
                printFile(element);
                fileCount++;
                totalFileSize += element.length();
            } else {
                printDir(element);
                dirCount++;
            }
        }
        System.out.printf("%,15d файлов %,15d байт\n%,15d папок %,15d байт свободно\n\n",
                fileCount,
                totalFileSize,
                dirCount,
                f.getFreeSpace());
        showCursor();
    }

    private void printDir(File f) {
        System.out.printf("%s   <DIR>          %s\n",
                getCreationDateTime(f),
                f.getName());
    }

    private void printFile(File f) {
        System.out.printf("%s         %7d  %s\n",
                getCreationDateTime(f),
                f.length(),
                f.getName());
    }

    private String getCreationDateTime(File f) {
        try {
            BasicFileAttributes att = Files.readAttributes(Paths.get(f.getAbsolutePath()), BasicFileAttributes.class);
            FileTime time = att.creationTime();
            DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
            return dateFormat.format(att.creationTime().toMillis());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void process(String expression) {
        getParser().parse(this, expression);
    }
}
