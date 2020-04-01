package by.it.okatov.jd01_06;

public class TaskB1 {
    public static void main(String[] args) {
        String text = Poem.text;
        char ch1 = ' ';
        for (char ch : text.toCharArray()) {
            if (!Character.isLetter(ch)) {
                text = text.replace(ch, ch1);
            }
        }
        text = text.replaceAll("  ", " ");//Заменить двойные пробелы одинарным
        String[] arrayOfVowels = {"я", "е", "и", "ы", "э", "у", "ё", "ю", "о", "а"};

        text = text.trim();
        String[] separateWords = text.split(" ");

        process(separateWords, arrayOfVowels);
    }

    private static void process(String[] text, String[] vowels) {
        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (text[i].length() < 2) {
                    break;
                }
                if (!text[i].startsWith(vowels[j]) && !text[i].startsWith(vowels[j].toUpperCase())) {
                    if (text[i].endsWith(vowels[j]) || text[i].endsWith(vowels[j].toUpperCase())) {
                        System.out.println(text[i]);
                        break;
                    }
                } else {
                    break;
                }

            }
        }
    }
}
