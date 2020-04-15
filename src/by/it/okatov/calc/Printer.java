package by.it.okatov.calc;

public class Printer {
    void print(Var var) {
        if (var != null)
            System.out.println(var);
    }

    void print(String str) {
        if (str != null && str != "") {
            System.out.println(str);
        }
    }
}
