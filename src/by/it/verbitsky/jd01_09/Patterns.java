package by.it.verbitsky.jd01_09;

interface Patterns {
    //для хранения паттернов регэкс
    String OPERATION = "[-+*/]";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{"+SCALAR+"(,"+ SCALAR + ")*}";
    String MATRIX = "\\{"+ VECTOR +"(,"+ VECTOR + ")*}";
}
