package by.it.borys.calc;


import by.it.borys.jd02_05.Message;
import sun.awt.AWTAccessor;

import java.io.*;
import java.util.*;

abstract class Var implements Operation {
    private static Map<String, Var> map = new HashMap<>();
    private static Map<String, Var> sortmap = new TreeMap<>();

    static Var saveVar(String name, Var var) {
        map.put(name, var);
        sortmap.put(name,var);
        printToFile(Var.getSortmap(), dir(ConsoleRunner.class)+"vars.txt");
        return var;
    }
    static Map<String, Var> getMap(){
        return map;
    }
    static Map<String, Var> getSortmap(){
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

    static Var createVar(String operand) throws CalcExeption {
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
        else {
                Var var = map.get(operand);
                if (var != null) return var;
             else throw new CalcExeption(ResMan.res.get(Messages.incorrname) + operand);
        }
    }
    static void printToFile(Map<String,Var> map,String fileName){
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))){
            Set<Map.Entry<String,Var>> set= map.entrySet();
            for (Map.Entry<String, Var> entry : set) {
 pw.println(entry.getKey()+"="+entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String dir(Class<?> cl){
        String path = System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String clD = cl.getName().replace(".",File.separator).replace(cl.getSimpleName(),"");
        return path+clD;
    }

    @Override
    public Var add(Var other) throws CalcExeption {
        throw new CalcExeption(String.format(ResMan.res.get(Messages.addop), this,other));
           }

    @Override
    public Var sub(Var other) throws CalcExeption {
        throw new CalcExeption(String.format(ResMan.res.get(Messages.subop), this,other));
           }

    @Override
    public Var mul(Var other) throws CalcExeption {
        throw new CalcExeption(String.format(ResMan.res.get(Messages.mulop), this,other));

    }

    @Override
    public Var div(Var other) throws CalcExeption {
        throw new CalcExeption(String.format(ResMan.res.get(Messages.divop), this,other));
          }
}
