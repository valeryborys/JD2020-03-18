package by.it.okatov.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {
    private final List<Integer> studentsGades = new ArrayList<Integer>();

    public static void main(String[] args) {
        TaskA1 instance = new TaskA1();
        int marksQuant = 40;
        for (int i = 0; i < marksQuant; i++) {
            instance.studentsGades.add((int) (Math.random() * 10 + 1));
        }

        System.out.println(instance.studentsGades);
        clearBad(instance.studentsGades);
        System.out.println(instance.studentsGades);
    }

    static void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() <= 3) {
                iterator.remove();
            }
        }
    }
}
