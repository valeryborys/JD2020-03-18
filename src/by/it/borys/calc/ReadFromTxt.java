package by.it.borys.calc;

public class ReadFromTxt implements CreateVar {
    @Override
    public Var createVar(String key)  {
        Var value = Var.getMap().get(key);
        ChooseCreation cs = new ChooseCreation();
        CreateVar cv = null;
        try {
            cv = cs.chooseFactory(value.toString());
        } catch (CalcExeption calcExeption) {
            calcExeption.printStackTrace();
        }
        Var var = cv.createVar(value.toString());
        return var;
    }
}
