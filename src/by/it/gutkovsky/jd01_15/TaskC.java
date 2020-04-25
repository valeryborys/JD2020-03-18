package by.it.gutkovsky.jd01_15;

import java.util.Scanner;

class TaskC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine().trim();
            if (input.equals("end")) {
                break;
            }
            if (input.equals("cd")) {
                System.out.println(Commands.path); // печатаем текущий путь
            } else if (input.equals("cd ..")) {
                System.out.println(Commands.getNewDirectory()); // подымаемся  на каталог вверх
            } else if (input.equals("dir")) {
                Commands.printDirProperties(Commands.path); // печатаем содержимое папки
            } else if (input.contains(" ")) {
                System.out.println(Commands.getNewDirectory(input));
            } else {
                System.out.println("\"" + input + "\"" + "  не является внутренней или внешней \n" +
                        "командой, исполняемой программой или пакетным файлом.\n");
            }
        }
    }
}
