package by.it.verbitsky.calc;

interface Patterns {
    //для хранения паттернов регэкс

    String OPERATION = "(?<=[^{,=*+/-])[=+*/-]";
    String OPERATION_IN_BRACERS = "[(]([^()]+)[)]";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{" + SCALAR + "(, ?" + SCALAR + ")*}";
    String MATRIX = "\\{" + VECTOR + "(, ?" + VECTOR + ")*}";

    String COMMAND_PRINTVAR = "printvar";
    String COMMAND_SORTVAR = "sortvar";
    String COMMAND_CLEAR_MEMORY = "clear";

    String COMMAND_CHANGE_LOCALE_EN = "en";
    String COMMAND_CHANGE_LOCALE_RU = "ru";
    String COMMAND_CHANGE_LOCALE_BY = "be";


    String EMPTY_BUFFER = "Buffer is empty";
}
