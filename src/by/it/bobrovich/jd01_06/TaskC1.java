package by.it.bobrovich.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    static int max = 0;

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        StringBuilder text1 = new StringBuilder("");
        Pattern pattern = Pattern.compile("[^\\n]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String line = matcher.group();
            if (max < line.length()) max = line.length();
        }
        Matcher matcher1 = pattern.matcher(text);
        while (matcher1.find()) {
            String line = matcher1.group();
            text1.append(changeLine(line));
        }
        String line = text1.toString().replaceAll("1", " ");
        System.out.println(line);
    }

    private static StringBuilder changeLine(String line) {
        StringBuilder lineBuilder = new StringBuilder(line);
        int lenght = line.length();
        while(lenght<max){
            Pattern pattern = Pattern.compile("(( ){1,})");
            Matcher matcher = pattern.matcher(lineBuilder);
            while (matcher.find() && lenght < max) {
                int position = matcher.end();
                lineBuilder.insert(position, "1");
                lenght++;
            }
        }

        lineBuilder.append("\n");
        return lineBuilder;
    }
}
