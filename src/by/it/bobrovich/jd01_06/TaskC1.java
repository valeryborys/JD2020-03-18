package by.it.bobrovich.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    static int max = 0;

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[^\\n]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String line = matcher.group();
            if (max < line.length()) max = line.length();
        }
        Matcher matcher1 = pattern.matcher(text);
        while (matcher1.find()) {
            String line = matcher1.group();
            changeLine(line);
        }
    }

    private static void changeLine(String line) {
        StringBuilder lineBuilder = new StringBuilder(line);
        int lenght = line.length();
        Pattern pattern = Pattern.compile(" .+? ");
        Matcher matcher = pattern.matcher(lineBuilder);
            while (matcher.find()) {
                int position = matcher.start();
                lineBuilder.insert(position, "1");
            }

        System.out.println(lineBuilder);
    }
}
