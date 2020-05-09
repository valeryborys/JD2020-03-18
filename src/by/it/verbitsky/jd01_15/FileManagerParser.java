package by.it.verbitsky.jd01_15;

class FileManagerParser implements FileManagerStrings {
    protected void parse(FileManager fm, String expression) {
        //Пустой cd
        if (expression.matches(FileManagerStrings.COMMAND_PATTERN_CD_EMPTY)) {
            Command cmd = new Command(FileManagerStrings.COMMAND_CD, "");
            executeCommand(fm, cmd);
            return;
        }
        //Cd ..
        if (expression.matches(FileManagerStrings.COMMAND_PATTERN_CD_UP)) {
            Command cmd = new Command(FileManagerStrings.COMMAND_CD, FileManagerStrings.ARG_DOTS);
            executeCommand(fm, cmd);
            return;
        }

        // cd <path or dirname>
        if (expression.matches(FileManagerStrings.COMMAND_PATTERN_CHANGEDIR)) {
            Command cmd = new Command(FileManagerStrings.COMMAND_CD, getArgs(expression));
            executeCommand(fm, cmd);
            return;
        }

        if (expression.matches(FileManagerStrings.COMMAND_PATTERN_DIR_EMPTY)) {
            Command cmd = new Command(FileManagerStrings.COMMAND_DIR, "");
            executeCommand(fm, cmd);
            return;
        }
        Command cmd = new Command("", "");
    }

    private String getArgs(String expression) {
        return expression
                .replaceFirst(FileManagerStrings.COMMAND_CD, "")
                .trim();
    }

    private void executeCommand(FileManager fm, Command cmd) {
        switch (cmd.getCommand()) {
            case "dir": {
                fm.printCurrentDir(cmd);
                break;
            }
            case "cd": {
                fm.changeDir(cmd);
                break;
            }
            default: {
                System.out.println(FileManagerStrings.COMMAND_NOT_FOUND);
            }
        }
    }

}
