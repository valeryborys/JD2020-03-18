package by.it.lemesh.calc;

import java.util.*;

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
}
