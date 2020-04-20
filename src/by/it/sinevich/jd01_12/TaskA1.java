package by.it.sinevich.jd01_12;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TaskA1 {
    private List<Integer> grades = new ArrayList<>();

    private void clearBad(List<Integer> grades){
        ListIterator<Integer> integerListIterator = grades.listIterator();
        while (integerListIterator.hasNext()){
            int grade = integerListIterator.next();
            if(grade<4){
                integerListIterator.remove();
            }
        }


    }
    public static void main(String[] args) {
        TaskA1 task = new TaskA1();
        for(int i=0; i<25; i++){
            task.grades.add((int) Math.ceil(Math.random()*10));
        }
        System.out.println(task.grades);
        task.clearBad(task.grades);
        System.out.println(task.grades);
    }

}
