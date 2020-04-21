package by.it.verbitsky.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class TaskA1 {
    private List<Integer> grades = new ArrayList<>();

    private void clearBad(List<Integer> grades) {
        /*Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next < 4) {
                iterator.remove();
            }
        */
        //равносильно тому, что в комментах
        grades.removeIf(next -> next < 4);
    }

    public static void main(String[] args) {
        Random random = new Random(123L);
        TaskA1 instance = new TaskA1();
        for (int i = 0; i < 25; i++) {
            instance.grades.add(random.nextInt(10) + 1);
        }
        System.out.println(instance.grades);
        instance.clearBad(instance.grades);
        System.out.println(instance.grades);

    }
}
