package by.it.tolstik.calc;

import java.io.*;
import java.util.*;

class Printer {
    void print(Var var) {
        if (var != null) {
            System.out.println(var);
        }
    }

    void printVar() {
        Map<String, Var> printMap = Var.getVars();
        if (printMap.size() != 0) {
            for (Map.Entry<String, Var> pair : printMap.entrySet()) {
                String key = pair.getKey();
                Var value = pair.getValue();
                System.out.printf("%s=%s\n", key, value);
            }
        } else System.out.println("There is no var");
    }

    void sortVar() {
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

    void saveToMemory() throws CalcException {
        String memory = getFile("vars.txt");
        Map<String, Var> printMap = Var.getVars();
        try (PrintWriter writeToMemory = new PrintWriter(memory)) {
            if (printMap.size() != 0) {
                for (Map.Entry<String, Var> pair : printMap.entrySet()) {
                    String key = pair.getKey();
                    Var value = pair.getValue();
                    writeToMemory.printf("%s=%s\n", key, value);
                }
            } else System.out.println("There is no vars in memory");
        } catch (FileNotFoundException e) {
            throw new CalcException("Error: FileNotFoundException: " + e);
        }
    }

    void loadFromMemory(Parser parser) {
        String memory = getFile("vars.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(memory))) {
            while (reader.ready()) {
                String line = reader.readLine();
                parser.calc(line);
            }
        } catch (IOException | CalcException e) {
            throw new RuntimeException(e);
        }

    }

    void printFromMemory() {
        String memory = getFile("vars.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(memory))) {
            while (reader.ready()) {
                String line = reader.readLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    void cleanMemory() throws CalcException {
        String memory = getFile("vars.txt");
        Map<String, Var> printMap = Var.getVars();
        printMap.clear();
        try (PrintWriter writeToMemory = new PrintWriter(memory)) {
            if (printMap.size() != 0) {
                for (Map.Entry<String, Var> pair : printMap.entrySet()) {
                    String key = pair.getKey();
                    Var value = pair.getValue();
                    writeToMemory.printf("%s=%s\n", key, value);
                }
            } else System.out.println("There is no vars in memory");
        } catch (FileNotFoundException e) {
            throw new CalcException("Error: FileNotFoundException: " + e);
        }
    }


    static String getFile(String fileName) {
        String root = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = root + ConsoleRunner.class.getName().replace(".", File.separator);
        path = path.replace(ConsoleRunner.class.getSimpleName(), "");
        return path + fileName;
    }

}