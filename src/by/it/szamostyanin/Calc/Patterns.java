package by.it.szamostyanin.Calc;

public interface Patterns {
    String OPERATION="(?<=[^{,=*/+-])[=*/+-]";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String OPERATION_IN_BRACERS = "[(]([^()]+)[)]";
    String VECTOR = "\\{" + SCALAR + "(, ?" + SCALAR + ")*}";
    String MATRIX = "\\{" + VECTOR + "(, ?" + VECTOR + ")*}";
}