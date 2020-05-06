package by.it.bobrovich.calc;

public interface Patterns {
    String OPERATIONS = "(?<=[^/{},=*+-])[+-/*=]";
    String SCALAR = "-?[0-9]+\\.?[0-9]*";
    String VECTOR = "\\{(("+ SCALAR +"),?)+}";
    String MATRIX = "\\{(("+ VECTOR +"),?)+}";
}
