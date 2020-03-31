package by.it.okatov.jd01_06;

public class TaskC2 {
    public static void main(String[] args) {
        String text = Poem.text;

        long start = System.nanoTime();
        text = slow(text);
        long end = System.nanoTime();
        long diff = end - start;
        System.out.println(text);
        System.out.printf("Start time: %d%nFinish time: %d%nDuration: %d%nDuration in plain seconds: %f%n%n%n", start, end, diff, diff / 1000000000.);

        text = Poem.text;
        start = System.nanoTime();
        text = fast(text);
        end = System.nanoTime();
        diff = end - start;
        System.out.println(text);
        System.out.printf("Start time: %d%nFinish time: %d%nDuration: %d%nDuration in plain seconds: %f%n", start, end, diff, diff / 1000000000.);

    }

    private static String slow(String text) {
        String[] separateWords = getWords(text);


        String testString = "";
        int n = separateWords.length;

        for (; testString.length() < 100000; ) {
            for (int j = 0; j < n; j++) {
                testString = testString.concat(separateWords[j] + " ");
            }
        }

        return testString;
    }

    private static String fast(String text) {
        String[] separateWords = getWords(text);

        StringBuilder testString = new StringBuilder();
        int n = separateWords.length;

        for (; testString.length() < 100000; ) {
            for (int i = 0; i < n; i++) {
                testString.append(separateWords[i]);
                testString.append(" ");
            }
        }

        return testString.toString();
    }


    private static String[] getWords(String text) {
        char ch1 = ' ';
        for (char ch : text.toCharArray()) {
            if (!Character.isLetter(ch)) {
                text = text.replace(ch, ch1);
            }
        }
        text = text.replaceAll("  ", " ");//Заменить двойные пробелы одинарным

        text = text.trim();
        return text.split(" ");
    }
}
