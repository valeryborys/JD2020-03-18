package by.it.okatov.calc.temp;

public class Printer {
    void print(Var var) {
        if (var != null) {
            if (var.getStrName() != null) {
                System.out.println(var.getStrName() + " = " + var);
            } else {
                System.out.println(var);
            }
        }

    }

    void print(String str) {
        if (str != null && str != "") {
            System.out.println(str);
        }
    }

    void print(String name, Var var) {

    }
}
