package by.it.akhmelev.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    private List<Integer> grades=new ArrayList<>();

    private void clearBad(List<Integer> grades){
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()){
            Integer grade = iterator.next();
            if (grade<4){
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        TaskA1 instance=new TaskA1();
        Random random=new Random(123L);
        for (int i = 0; i < 25; i++) {
            instance.grades.add(random.nextInt(10)+1);
        }
        System.out.println(instance.grades);
        instance.clearBad(instance.grades);
        System.out.println(instance.grades);

    }
}
