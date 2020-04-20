package by.it.lemesh.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        StringBuilder sb = new StringBuilder();
        while (!(line = sc.nextLine()).equals("end")) {
            sb.append(line);
        }
        sb = new StringBuilder(sb.toString().replaceAll("isn't", "don't"));
        Pattern p = Pattern.compile("[;!—//., -]+");
        String[] str = p.split(sb.toString());
        ArrayList<String> words = new ArrayList<>(Arrays.asList(str));
        for (String s : str) {
            int frequency = Collections.frequency(words,s);
            System.out.println(s+"="+frequency);
        }
    }
}
