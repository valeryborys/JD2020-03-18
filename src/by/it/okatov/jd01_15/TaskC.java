package by.it.okatov.jd01_15;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        String directory = TaskB.getFileName(TaskC.class, "");
        Path path = Paths.get(directory);
        Date lastModDate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy hh.mm");
        String sDate;
        int countFiles = 0;
        int countDirs = 0;
        int filesLength = 0;

        while (true) {
            System.out.print(path + "> ");
            input = sc.nextLine();
            //resolveCommands
            if (input.equals("cd ..") || input.equals("cd..")) {
                currentCommand = Command.ChangeDirParent;
            } else if (input.startsWith("cd") && !input.contains("..")) {
                currentCommand = Command.ChangeDirAddress;
            } else if (input.equals("dir")) {
                currentCommand = Command.Directory;
            } else {
                currentCommand = Command.Unresolved;
            }

            if (input.equals("END") || input.equals("end") || input.equals("End")) {
                return;
            }

            //switchState
            switch (currentCommand) {
                case ChangeDirParent:
                    path = getFileName("", path.getParent());
                    break;
                case ChangeDirAddress:
                    path = getFileName(input.replace("cd ", ""), path);
                    break;
                case Directory:
                    File f = new File(path.toString());
                    File[] dirs = f.listFiles();
                    for (File dir : dirs) {
                        lastModDate = new Date(dir.lastModified());
                        sDate = String.format(dateFormat.format(lastModDate));
                        if (dir.isDirectory()) {
                            System.out.printf("%s%15s%7s %s%n", sDate, "<DIR>", "", dir.getName());
                            countDirs++;
                        } else if (dir.isFile()) {
                            System.out.printf("%s%7s%15d %s%n", sDate, "", dir.length(), dir.getName());
                            countFiles++;
                            filesLength += dir.length();
                        }
                    }
                    String fi;
                    String di;
                    //nounCaseChange
                    if (countFiles == 1) {
                        fi = "файл";
                    } else if (countFiles >= 2 && countFiles < 5) {
                        fi = "файла";
                    } else {
                        fi = "файлов";
                    }

                    if (countDirs == 1) {
                        di = "папка";
                    } else if (countDirs >= 2 && countDirs < 5) {
                        di = "папки";
                    } else {
                        di = "папок";
                    }
                    System.out.printf("%15d %s %12d байт%n%15d %s %12d байт свободно %n",
                            countFiles, fi, filesLength, countDirs, di, f.getFreeSpace());

                    break;
                case Unresolved:
                    System.out.println("\"" + input + "\" не является внутренней или внешней ");
                    System.out.println("командой, исполняемой программой или пакетным файлом.");
                    break;
                default:
                    return;
            }
        }
    }

    private enum Command {
        ChangeDirParent,
        ChangeDirAddress,
        Directory,
        Unresolved
    }

    public static Command currentCommand = Command.Directory;

    public static Path getFileName(String dirName, Path curPath) {

        if (!dirName.contains(File.separator) || !dirName.contains("\\")) {
            curPath = Paths.get(curPath.toString() + File.separator + dirName);
        } else {
            curPath = Paths.get(dirName);
        }
        return curPath;
    }
}


