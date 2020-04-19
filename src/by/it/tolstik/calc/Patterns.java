package by.it.tolstik.calc;

interface Patterns {
    String OPERATION = "[-=+/*]";
    String SCALAR = "-?[0-9]+\\.?[0-9]*";
    String VECTOR = "\\{(" + SCALAR + ",?)+}";
    String MATRIX = "\\{((\\{((" + SCALAR+ "),?)+}),?)+}";

}
