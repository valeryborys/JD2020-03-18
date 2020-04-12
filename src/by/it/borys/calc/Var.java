package by.it.borys.calc;


import java.util.*;

abstract class Var implements Operation {

    private static Map<String, Var> map = new HashMap<>();
    private static TreeMap<String, Var> sortmap = new TreeMap<>();

    static Var saveVar(String name, Var var) {
        map.put(name, var);
        sortmap.put(name,var);
        return var;
    }
    static Map<String, Var> getMap(){
        return map;
    }
    static TreeMap<String, Var> getSortmap(){
        return sortmap;
    }
    static void printvar(Map<String, Var> map){
        Set<Map.Entry<String,Var>> stv = map.entrySet();
        Iterator<Map.Entry<String,Var>> iterator = stv.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Var> mp = iterator.next();
            System.out.println(mp.getKey()+"="+mp.getValue());
        }
    }

    static Var createVar(String operand) {
        operand = operand.trim().replaceAll("\\s*", "");
        if (operand.matches(Patterns.SCALAR)) {
            return new Scalar(operand);
        }
        if (operand.matches(Patterns.VECTOR)) {
            return new Vector(operand);
        }
        if (operand.matches(Patterns.MATRIX)) {
            return new Matrix(operand);
        }
        if (map.containsKey(operand)) return map.get(operand);
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения " + this + "+" + other + " невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания " + this + "-" + other + " невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения " + this + "*" + other + " невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления " + this + "/" + other + " невозможна");
        return null;
    }
}
