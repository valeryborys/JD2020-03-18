package by.it.gutkovsky.calc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

class Printer {
    void print(Var var) {
        if (var != null) {
            System.out.println(var);
        }
    }

    // jd01_11 - taskB part2
    static void printVar() {

        Map<String, Var> printMap = Var.getVars();
        if (printMap.size() != 0) {
            for (Map.Entry<String, Var> pair : printMap.entrySet()) {
                String key = pair.getKey();
                Var value = pair.getValue();
                System.out.printf("%s=%s\n", key, value);
            }
        } else System.out.println("There is no var");

        // варианты вывода (все рабочие)
//        Map<String, Var> map1 = Var.getVars();
//        for (Map.Entry<String, Var> pair : map1.entrySet()){
//            System.out.println(pair.getKey() + "=" + pair.getValue());
//        }

//        Iterator<Map.Entry<String, Var>> iterator = Var.getVars().entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry<String, Var> pair = iterator.next();
//            String key = pair.getKey();
//            Var value = pair.getValue();
//            System.out.printf("%s=%s\n",key, value);
//        }
    }

    // jd01_11 - taskC part2
    public static void sortVar() {
        Map<String, Var> varMap = Var.getVars();
        if (varMap.size() != 0) {
            TreeMap<String, Var> sortedMap = new TreeMap<>(varMap);
            for (Map.Entry<String, Var> pair : sortedMap.entrySet()) {
                String key = pair.getKey();
                Var value = pair.getValue();
                System.out.printf("%s=%s\n", key, value);
            }
        } else System.out.println("There is no var");
    }

    static void saveToMemory() throws CalcException {
        String memory = getMemoryFile();
        Map<String, Var> printMap = Var.getVars();
        try (PrintWriter writeToMemory = new PrintWriter(memory)) {
            if (printMap.size() != 0) {
                for (Map.Entry<String, Var> pair : printMap.entrySet()) {
                    String key = pair.getKey();
                    Var value = pair.getValue();
                    writeToMemory.printf("%s=%s\n", key, value);
                }
            } else System.out.println("There is no var in memory");
        } catch (FileNotFoundException e) {
            throw new CalcException("Error: FileNotFoundException: " + e);
        }
    }

    private static String getMemoryFile() {
        String fileMemory = "vars.txt";
        String root = System.getProperty("user.dir") + File.separator + "src" + File.separator; // D:\gutkovsky\JD2020-03-18\src\
        String path = root + ConsoleRunner.class.getName().replace(".", File.separator);
        path = path.replace(ConsoleRunner.class.getSimpleName(), "");
        return path + fileMemory;
    }

}
