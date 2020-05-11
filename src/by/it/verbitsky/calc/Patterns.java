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


    //report patterns:

    String TIMESTAMP_PATTERN = "<dd-MM-yyyy HH:mm:ss> ";

    String SIMPLE_REPORT_HEADER = "\n---------------------------------------------------------------\n" +
            "Simple report\nProgram starts in: %s\nProgram ends in: %s\n\n";

    String SIMPLE_REPORT_FOOTER = "\n\nTotal events: %3d\nEnd simple report\n" +
            "\n---------------------------------------------------------------\n";

    String FULL_REPORT_HEADER = "\n---------------------------------------------------------------\n" +
            "Full report\nProgram starts in: %s\nProgram ends in: %s\n\n";

    String FULL_REPORT_FOOTER = "\n\nTotal errors: %3d, total operations: %3d, total events: %3d\nEnd full report\n" +
            "\n---------------------------------------------------------------\n";

}
