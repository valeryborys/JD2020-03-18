package by.it.verbitsky.jd01_15;

class FileManagerParser implements FileManagerStrings {
//cd directory

    public void parse(String expression) {
        //String words = expression.split()
        int delimeterPos = expression.indexOf(FileManagerStrings.COMMAND_DELIMITER);
        String command = expression.substring(0, delimeterPos);
        //System.out.println("command - "+ command);
    }

}
