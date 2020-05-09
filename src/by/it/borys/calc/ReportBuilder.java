package by.it.borys.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;

abstract class ReportBuilder {

    Deque<String> report = new ArrayDeque<>();
    abstract void reportHeading();
    abstract void reportBody(String str);
    abstract void reportClosing();

    public void printReport() {
        Path path = Paths.get(Var.dir(ConsoleRunner.class) + "report.txt");
        try (PrintWriter pw = new PrintWriter(new FileWriter(String.valueOf(path),true))) {
            while (!report.isEmpty()) {
                pw.println(report.pollFirst());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
