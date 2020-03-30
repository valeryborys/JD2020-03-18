package by.it.okatov.jd01_06;

public class TaskB2 {
    public static void main(String[] args) {
        String text = Poem.text;
        taskWithoutRegEx(text);

    }

    private static void taskWithoutRegEx(String text) {
        char ch1 = ' ';
        for (char ch : text.toCharArray()) {
            if (!Character.isLetter(ch) && !Character.isSpaceChar(ch)) {
                if (ch == '\n') {
                    continue;
                }

                text = text.replace(Character.toString(ch), "");
            }
        }

        text = text.replaceAll("  ", " ");
        String[] splited = text.split("\n");
        sortingBasedOnLettersCount(splited);
    }

    private static void sortingBasedOnLettersCount(String[] splited) {
        //Arrays.sort
    }
}
