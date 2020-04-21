package by.it.borys.calc;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        readMapFromTxt(Var.dir(ConsoleRunner.class) + "vars.txt");
        Scanner sc = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(line = sc.nextLine()).equals("end")) {
            if (line.equals("printvar")) {
                Var.printvar(Var.getMap());
                continue;
            }
            if (line.equals("sortvar")) {
                Var.printvar(Var.getSortmap());
                continue;
            }
            try {
                Var result = parser.calc(line);
                log(line);
                printer.print(result);
                log(result.toString());
            } catch (CalcExeption e) {
                System.out.println(e.getMessage());
                log(e.getMessage());
            }
        }
    }
//считывает сохраненные в файл переменные
private static void readMapFromTxt(String filename) {
    Path path = Paths.get(filename);
    Parser parser = new Parser();
    try{
        System.out.println("Значения ранее сохраненных переменных: ");
        Scanner sc = new Scanner(path);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            parser.calc(line);
            System.out.println(line);
        }
    } catch (IOException | CalcExeption e) {
        e.printStackTrace();
    }
}
//делает лог 50-ти последних изменений и ошибок в файл
private static void log(String log) {
    Path path = Paths.get(Var.dir(ConsoleRunner.class) + "log.txt");
    File f = new File(String.valueOf(path));
    ArrayDeque<String> queue = new ArrayDeque<>();
    Scanner sc=null;
    if (f.exists()){
    try {
        sc = new Scanner(path);
        while (sc.hasNext()) {
            queue.addFirst(sc.nextLine());
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    finally {
        assert sc != null;
        sc.close();
    }}
    queue.addFirst(log);
    while (queue.size()>50){
        queue.pollLast();
    }
    try (PrintWriter pw = new PrintWriter(new FileWriter(String.valueOf(path)))){
        while (!queue.isEmpty()) {
            pw.println(queue.pollLast());
        }
        } catch (IOException e) {
        e.printStackTrace();
    }

}
}
