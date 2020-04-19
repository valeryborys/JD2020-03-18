package by.it.verbitsky.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;

class TaskB3 {
    static String process(ArrayList<String> peoples) {
        int size;
        int i;

        while (peoples.size() > 1) {                     // Создаём петлю, которая повторяется
            // до тех пор пока длина не будет 1
            if (peoples.size() % 2 != 0) {              // Если длина списка Нечётная
                i = 0;
                size = peoples.size() / 2;                // Количество элементов которые удалятся
                for (int j = 0; j < size; j++) {   // Удаляем их через for
                    peoples.remove(i + 1);
                    i++;
                }
                peoples.remove(0);                      // После удаляем первый

            } else if (peoples.size() % 2 == 0) {        // Если длина списка Чётная
                i = 0;                              // Далее тоже что и выше
                size = peoples.size() / 2;

                for (int j = 0; j < size; j++) {
                    peoples.remove(i + 1);
                    i++;
                }
            }
        }
        return peoples.get(0);
    }


    static String process(LinkedList<String> list) {
        boolean flag = false;
        while (list.size() > 1) {
            if (!flag) {
                list.offerLast(list.pollFirst());
                flag = !flag;
            } else {
                list.poll();
                flag = !flag;
            }
        }
        return list.peekFirst();
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < 4096; i++) {
            arrayList.add("Man" + (i + 1));
            linkedList.add("Man" + (i + 1));
        }

        long start = System.nanoTime();
        System.out.printf("Arraylist: Last man is %s\n", process(arrayList));
        long end = System.nanoTime();
        System.out.println("Результат работы ArrayList");
        System.out.println((end - start) / 1000);

        System.out.println();
        start = System.nanoTime();
        System.out.printf("Linkedlist: Last man is %s\n", process(linkedList));
        end = System.nanoTime();
        System.out.println("Результат работы LinkedList");
        System.out.println((end - start) / 1000);


    }
}
