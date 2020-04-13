package by.it.bobrovich.jd01_09;

public interface Patterns {
    static final String OPERATIONS = "[-+*/]";
    static final String SCALAR = "-?[0-9]+\\.?[0-9]*";
    static final String VECTOR = "\\{(("+ SCALAR +"),?)+}";
    static final String MATRIX = "\\{(("+ VECTOR +"),?)+}";
}
