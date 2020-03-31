package by.it.borys.jd01_06;


public class TaskB1 {
    public static void main(String[] args) {
        findWords(Poem.text);
    }

    private static void findWords(String text) {
        StringBuilder sb = new StringBuilder(text);
        String vowels = "аеёиоыуэюяАЕЁИОУЭЮЯ";
        String[] words = text.split("[\\s*(\\s|,|!|\\.|\\-|\\:)\\s*]");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= 2) {

                char firstchar = words[i].charAt(0);
                char lastchar = words[i].charAt(words[i].length() - 1);

                if (vowels.indexOf(firstchar) < 0 && vowels.indexOf(lastchar) >= 0) {
                    System.out.println(words[i]);

                }
            }
        }


    }
}
