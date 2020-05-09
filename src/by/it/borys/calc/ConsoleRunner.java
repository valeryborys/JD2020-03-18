package by.it.borys.calc;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        ReportDirector rp = new ReportDirector();
        ReportBuilder rb =Math.random() > 0.5 ? new ReportFullBuilder(): new ReportShortBuilder();
        rp.setBuilder(rb);
        rp.reportHeading();
        readMapFromTxt(Var.dir(ConsoleRunner.class) + "vars.txt");
        Scanner sc = new Scanner(System.in);
        String line;
        Locale locale;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(line = sc.nextLine()).equalsIgnoreCase("end")) {
            log(line);
            rp.reportBody(line);
            switch (line) {
                case "printvar":
                    Var.printvar(Var.getMap());
                    break;
                case "sortvar":
                    Var.printvar(Var.getSortmap());
                    break;
                case "en":
                    locale = new Locale("en", "US");
                    ResMan.res.setLocale(locale);
                    System.out.println(ResMan.res.get(Messages.localechange));
                    log(ResMan.res.get(Messages.localechange));
                    rp.reportBody(ResMan.res.get(Messages.localechange));
                    break;
                case "ru":
                    locale = new Locale("ru", "RU");
                    ResMan.res.setLocale(locale);
                    System.out.println(ResMan.res.get(Messages.localechange));
                    log(ResMan.res.get(Messages.localechange));
                    rp.reportBody(ResMan.res.get(Messages.localechange));
                    break;
                case "be":
                    locale = new Locale("be", "BY");
                    ResMan.res.setLocale(locale);
                    System.out.println(ResMan.res.get(Messages.localechange));
                    log(ResMan.res.get(Messages.localechange));
                    rp.reportBody(ResMan.res.get(Messages.localechange));
                    break;
                default:
                    try {
                        Var result = parser.calc(line);
                        printer.print(result);
                        log(result.toString());
                        rp.reportBody(result.toString());
                    } catch (CalcExeption e) {
                        System.out.println(e.getMessage());
                        log(e.getMessage());
                        rp.reportBody(e.getMessage());
                    }
            }
        }
        rp.reportClosing();
    }

    //считывает сохраненные в файл переменные
    private static void readMapFromTxt(String filename) {
        Path path = Paths.get(filename);
        Parser parser = new Parser();
        try {
            System.out.println(ResMan.res.get(Messages.savedvalues));
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
        Scanner sc = null;
        if (f.exists()) {
            try {
                sc = new Scanner(path);
                while (sc.hasNext()) {
                    queue.addFirst(sc.nextLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                assert sc != null;
                sc.close();
            }
        }
        queue.addFirst(log);
        while (queue.size() > 50) {
            queue.pollLast();
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(String.valueOf(path)))) {
            while (!queue.isEmpty()) {
                pw.println(queue.pollLast());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
