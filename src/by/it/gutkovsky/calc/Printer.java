package by.it.gutkovsky.calc;

import java.util.Map;

class Printer {
    void print(Var var) {
        if (var != null) {
            System.out.println(var);
        }
    }

    // jd01_11 - taskB part2
    static  void printVar(){

        Map<String, Var> printMap = Var.getVars();
        for (Map.Entry<String, Var> pair : printMap.entrySet()){
            String key = pair.getKey();
            Var value = pair.getValue();
            System.out.printf("%s=%s\n",key, value);
        }

//        Iterator<Map.Entry<String, Var>> iterator = Var.getVars().entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry<String, Var> pair = iterator.next();
//            String key = pair.getKey();
//            Var value = pair.getValue();
//            System.out.printf("%s=%s\n",key, value);
//        }
    }

    // jd01_11 - taskC part2
    public static void sortvar() {

        System.out.println("sortvar ended"); // временная заглушка
    }

}
