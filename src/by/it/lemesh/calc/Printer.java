package by.it.lemesh.calc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Printer {
    void print(Var var) {
        System.out.println(var);
    }

    void printVars() {
        Set<Map.Entry<String, Var>> mapSet = Var.getVars().entrySet();
        for (Map.Entry<String, Var> varEntry : mapSet) {
            System.out.println(varEntry.getKey() + "=" + varEntry.getValue());
        }
    }

    void printSortVars() {
        Map<String, Var> map = Var.getVars();
        TreeMap<String, Var> tree = new TreeMap<>(map);
        Set<Map.Entry<String, Var>> treeSet = tree.entrySet();
        for (Map.Entry<String, Var> treeEntry : treeSet) {
            System.out.println(treeEntry.getKey() + "=" + treeEntry.getValue());
        }
    }

    void printLog(String line) {
        long countLines = 0;
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        path += Printer.class.getName().replace(Printer.class.getSimpleName(), "").replace(".", File.separator);
        String fileName = path + "log.txt";

        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            countLines = lines.count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (countLines == 50) {
            StringBuilder sb = new StringBuilder();
            try (BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
                bf.readLine();
                for (long i = 1; i < 50; i++) {
                    sb.append(bf.readLine()).append("\n");
                }
                sb.append(line);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (FileOutputStream fos = new FileOutputStream(fileName)) {
                fos.write(sb.toString().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (BufferedWriter bf = new BufferedWriter(new FileWriter(fileName, true))) {
                bf.newLine();
                bf.write(line);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
