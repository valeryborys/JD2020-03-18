package by.it.borys.jd01_06;

public class TaskC2 {
    public static void main(String[] args) {
          String text = getWords(Poem.text);
        long start1 = System.nanoTime();//получает системное время в наносекундах до запуска метода
        System.out.println(slow(text));
        long finish1 = System.nanoTime();//получает системное время в наносекундах после выполнения метода
        System.out.println(finish1 - start1);
        long start2 = System.nanoTime();
        System.out.println(fast(text));
        long finish2 = System.nanoTime();
        System.out.println(finish2 - start2);
    }

    static String slow(String text) {
        String[] words = text.split( " ");
        String line = new String();
        while (line.length() < 100000)
            for (int i = 0; i < words.length; i++) {
                line = line.concat(words[i]).concat(" ");
            }
        return line;
    }

    static String fast(String text) {
        String[] words = text.split( " ");
        StringBuilder line = new StringBuilder();
        while (line.length() < 100000)
            for (int i = 0; i < words.length; i++) {
                line = line.append(words[i]).append(" ");
            }
        return line.toString();
    }

    static String getWords(String text) {
        text = text.replaceAll("[^а-яА-ЯёЁ]+", " ");
        String[] words = text.split(" ");
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            int j = (int) (Math.random() * words.length);
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            sb.append(words[i]).append(" ");
        }
        String randomwords = sb.toString();
        return randomwords;
    }
}

