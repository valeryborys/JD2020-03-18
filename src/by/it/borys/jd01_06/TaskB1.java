package by.it.borys.jd01_06;


public class TaskB1 {
    public static void main(String[] args) {
        findWords(Poem.text);
    }
  private static void findWords(String text) {
      String vowels = "аеёиоыуэюяАЕЁИОУЭЮЯ";
      String[] words = text.split("[^а-яА-яёЁ]");
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
  /*  private static void findWords(String text) {
        text = text.replaceAll("\\,", " ");
        text = text.replaceAll("\\.", " ");
        text = text.replaceAll("\\-", " ");
        text = text.replaceAll("\\:", " ");
        text = text.replaceAll("\\!", " ");
        text = text.replaceAll("\n", " ");
        String[] words = text.split(" ");
        String vowels = "аеёиоыуэюяАЕЁИОУЭЮЯ";
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].trim();
           if (words[i].length()>1) {
                char firstchar = words[i].charAt(0);
                char lastchar = words[i].charAt(words[i].length() - 1);
            if (vowels.indexOf(firstchar) < 0 && vowels.indexOf(lastchar) >= 0) {
                System.out.println(words[i]);
            }
              //System.out.println(words[i]+" "+firstchar+" "+lastchar);
           }
        }
        }*/

    }
