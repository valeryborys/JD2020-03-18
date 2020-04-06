package by.it.novikov.jd01_06;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskB1 {
    public static void main(String[] args) {
        printWords();
    }

    private static void printWords() {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();

            heAd(word);
        }
    }

    private static void heAd(String word) {
        char[] glasn = {'а', 'А', 'о', 'О', 'е', 'Е', 'и', 'И', 'у', 'У', 'ю', 'Ю', 'ы', 'э', 'Э', 'ё', 'Ё', 'я', 'Я'};
        boolean startsConconant = true;
        for (char a : glasn) {
            if (word.charAt(0) == a) {
                startsConconant = false;
                break;
            }
        }
        boolean endGlasn = false;
        if (startsConconant) {
            for (char a : glasn) {
                if (word.charAt(word.length() - 1) == a) {
                    endGlasn = true;
                    break;
                }
            }
        }
        if (startsConconant && endGlasn) {
            System.out.println(word);
        }
    }
}
