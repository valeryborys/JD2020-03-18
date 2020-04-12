package by.it.gutkovsky.calc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();
    // jd01_11 - taskA part2
    static Var saveVar (String name, Var var){
        vars.put(name, var);
        return var;
    }

    // jd01_11 - taskB part2
    static  void printVar(){
        Iterator<Map.Entry<String, Var>> iterator = vars.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Var> pair = iterator.next();
            String key = pair.getKey();
            Var value = pair.getValue();
            System.out.printf("%s=%s\n",key, value);
        }
    }

    static Var createVar(String strVar) {
        strVar = strVar.trim().replaceAll("\\s", "");
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        else if (vars.containsKey(strVar))
            return vars.get(strVar);
        return null;
    }


    @Override
    public Var add(Var other) {
        System.out.printf("Operation %s + %s is impossible\n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Operation %s - %s is impossible\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Operation %s * %s is impossible\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Operation %s / %s is impossible\n", this, other);
        return null;
    }

    @Override
    public String toString() {
        return "Abstract Var{}";
    }
}
