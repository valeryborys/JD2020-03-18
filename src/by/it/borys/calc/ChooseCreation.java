package by.it.borys.calc;

public class ChooseCreation {

    CreateVar chooseFactory(String operand) throws CalcExeption {
        operand = operand.trim().replaceAll("\\s*", "");
        if (operand.matches(Patterns.SCALAR)) {
            return new CreateScalar();
        }
        if (operand.matches(Patterns.VECTOR)) {
            return new CreateVector();
        }
        if (operand.matches(Patterns.MATRIX)) {
            return new CreateMatrix();
        }
       else {

            Var var = Var.getMap().get(operand);
            if (var != null){
               return new ReadFromTxt();
            }
            else throw new CalcExeption(ResMan.res.get(Messages.incorrname) + operand);
    }
    }
}
