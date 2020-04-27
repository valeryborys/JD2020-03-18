package by.it.verbitsky.jd01_15;

interface FileManagerStrings {
    //Commands
    String COMMAND_CD = "cd";
    String COMMAND_DIR = "dir";
    //Arguments
    String ARG_DOTS = "..";

    //Text Errors
    String PATH_NOT_FOUND = "Системе не удается найти указанный путь.";
    String COMMAND_NOT_FOUND = " не является внутренней или внешней командой, исполняемой программой или пакетным файлом";

    //Patterns for Parsing
    String DOTS_PATTERN = "(\\s)*..(\\s)*";
    String EMPTY_PATTERN = "(\\s)*";
    String COMMAND_PATTERN_CD_UP = "(\\s)*cd" + DOTS_PATTERN;
    String COMMAND_PATTERN_CD_EMPTY = "(\\s)*cd(\\s)*";
    String COMMAND_PATTERN_DIR_EMPTY = "(\\s)*dir(\\s)*";
    String COMMAND_PATTERN_CHANGEDIR = "(cd(\\s)*)([\\s\\p{Punct}a-zA-Z0-9]*)(\\s)*";
}
