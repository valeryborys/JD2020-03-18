package by.it.verbitsky.jd01_15;

class Command {
    private String command;
    private String[] args;

    //Constructors
    public Command(String command, String[] params) {
        this.command = command;
        this.args = params;
    }

    public Command(String command, String param) {
        this.command = command;
        this.args = new String[1];
        this.args[0] = param;
    }

    //Getters and Setters
    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }
}
