package by.it.novikov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        formatText();
    }

    private static void formatText() {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ][-:,.!а-яА-ЯёЁ ]+");
        Matcher matcher = pattern.matcher(text);
        int maxLength = 0;
        int countOfStrings = 0;
        while (matcher.find()) {
            if (maxLength < matcher.end() - matcher.start()) {
                maxLength = matcher.end() - matcher.start();
            }
            countOfStrings++;
        }

        String[] stringArray = new String[countOfStrings];
        int[] lengthArrat = new int[countOfStrings];
        int counter = 0;
        Pattern pattern2 = Pattern.compile("[а-яА-ЯёЁ][-:,.!а-яА-ЯёЁ ]+");
        Matcher matcher2 = pattern2.matcher(text);
        while (matcher2.find()) {
            stringArray[counter] = matcher2.group();
            lengthArrat[counter++] = matcher2.group().length();
        }

        for (int i = 0; i < stringArray.length; i++) {
            String elem = stringArray[i];
            int elementLength = lengthArrat[i];
            int diff = maxLength - elementLength;
            if (diff == 0) {
                System.out.println(elem);
            } else {
                String[] words = elem.split(" ");
                int spacesHave = words.length - 1;
                int spacesRequired = diff + spacesHave;
                int spacesLeft = spacesRequired % spacesHave;
                for (int j = 0; j < words.length; j++) {
                    System.out.print(words[j]);
                    if (j + 1 == words.length) {
                        continue;
                    }
                    for (int k = 0; k < spacesRequired / spacesHave; k++) {
                        System.out.print(" ");

                    }
                    if (spacesLeft > 0) {
                        System.out.print(" ");
                        spacesLeft--;
                    }
                }

                System.out.print("\n");
            }
        }

    }


}