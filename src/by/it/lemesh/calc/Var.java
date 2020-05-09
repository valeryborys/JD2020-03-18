package by.it.lemesh.calc;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Var implements Operation {
    private static Map<String, Var> vars = new HashMap<>();
    static ResMan res = ResMan.INSTANCE;

    public static Var saveVar(String name, Var var) {
        vars.put(name, var);
        saveTxt(vars);
        return var;
    }

    private static void saveTxt(Map<String, Var> vars) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        path += Var.class.getName().replace(Var.class.getSimpleName(), "").replace(".", File.separator);
        try (PrintWriter writer = new PrintWriter(path + "vars.txt")) {
            Set<Map.Entry<String, Var>> set = vars.entrySet();
            for (Map.Entry<String, Var> entry : set) {
                writer.print(entry.getKey() + "=" + entry.getValue() + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void loadMap() {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        path += Var.class.getName().replace(Var.class.getSimpleName(), "").replace(".", File.separator);
        try (BufferedReader br = new BufferedReader(new FileReader(path+"vars.txt"))) {
            String line;
            while (null != (line = br.readLine())) {
                String[] split = line.split("=");
                vars.put(split[0],createVar(split[1]));
            }
        } catch (IOException | CalcException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Var> getVars() {
        return vars;
    }

    static Var createVar(String line) throws CalcException {
        line = line.trim().replace(" ", "");
        if (line.matches(Patterns.SCALAR))
            return new Scalar(line);
        if (line.matches(Patterns.VECTOR))
            return new Vector(line);
        if (line.matches(Patterns.MATRIX))
            return new Matrix(line);
        if (vars.containsKey(line))
            return vars.get(line);
        else throw new CalcException(res.get(Messages.ERROR_CREATE) +" "+ line);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(res.get(Messages.ERROR_ADD));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(res.get(Messages.ERROR_SUB));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(res.get(Messages.ERROR_MUL));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(res.get(Messages.ERROR_DIV));
    }
}
