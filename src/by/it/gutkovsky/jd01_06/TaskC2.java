package by.it.gutkovsky.jd01_06;

class TaskC2 {

    public static void main(String[] args) {
// проверка массива слов
//        String[] test = getWords(Poem.text);
//        for (String s : test) {
//            System.out.println(s);
//        }
//        System.out.println(test.length);


        long startTime1 = System.nanoTime();
        System.out.println(slow(Poem.text));
        long stopTime1 = System.nanoTime();
        long deltaTime1 = (stopTime1 - startTime1) / 1000000;
        System.out.println("method slow() worked = " + deltaTime1 + " ms");

        long startTime2 = System.nanoTime();
        System.out.println(fast(Poem.text));
        long stopTime2 = System.nanoTime();
        long deltaTime2 = (stopTime2 - startTime2) / 1000000;
        System.out.println("method fast() worked = " + deltaTime2 + " ms");

    }

    private static String slow(String text) {
        String slowText = "";
        String[] arrayForConcat = getWords(text);
        for (int i = 0; i < 637; i++) {
            for (String s : arrayForConcat) {
                slowText = slowText.concat(s + " ");
            }
        }
        return slowText;
    }

    private static String fast(String text) {
        String[] arrrayForConcat = getWords(text);
        String fastText = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 637; i++) {
            for (String s : arrrayForConcat) {
                sb.append(s);
                sb.append(" ");
            }
            fastText = sb.toString();
        }
        return fastText;
    }

    private static String[] getWords(String text2) {
        String[] words = Poem.text.split("[^а-яА-ЯёЁ]+");
        return words;
    }

}
