package by.it.borys.jd01_12;

import java.util.*;

public class TaskA1 {
    private List<Integer> grades = new ArrayList<>();
    public static void main(String[] args) {
        TaskA1 instance = new TaskA1();
        Random grade = new Random(123L);
         for (int i = 0; i <25 ; i++) {
            instance.grades.add(grade.nextInt(10)+1);
        }
        System.out.println(instance.grades);
     instance.clearBad(instance.grades);
        System.out.println(instance.grades);
    }
    private void clearBad(List<Integer> grades){
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()){
            Integer val = iterator.next();
            if (val<=3){
              iterator.remove();
            }
        }

    }
}
