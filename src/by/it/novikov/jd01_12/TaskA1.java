package by.it.novikov.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TaskA1 {
    private List <Integer> grades = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 t = new TaskA1();
        for (int i = 0; i < 10; i++) {
            t.grades.add((int) (Math.random() * 10 + 1));
        }
        System.out.println(t.grades);
        t.clearBad(t.grades);
        System.out.println(t.grades);
    }

    void clearBad(List<Integer> grades){
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()){
            int grade = iterator.next();
            if (grade <=3){
                iterator.remove();
            }
        }
    }
}