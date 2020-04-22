package by.it.okatov.calc;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;

public class SaveLoadVars {
    public static void save(HashMap<String, Var> hMap, String path) {
        try (PrintWriter print = new PrintWriter(path)) {
            //print.
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static HashMap<String, Var> load() {
        return null;
    }
}
