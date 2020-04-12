package by.it.verbitsky.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Runner {
    public static void main(String[] args) {
//Check Task A
/*
        List<String> listA = new ListA<>();
        listA.add("10");
        listA.add("11");
        listA.add("12");
        listA.add("13");
        listA.add("14");
        listA.add("15");
        System.out.println(listA);
//Check Task B
        List<String> listB = new ListB<>();
        listB.add("one");
        listB.add("two");
        listB.add("three");
        listB.add("four");
        listB.add("five");
        System.out.println(listB);

        listB.add("six");
        listB.add(0, "zero");
        listB.remove(4);
        System.out.println(listB);
        listB.set(0, "nothing");
        System.out.println(listB.get(0));

        ArrayList<String> test = new ArrayList<>();
        test.add("1");
        test.add("2");
        test.add("3");
        test.add("4");
        test.add("5");
        //  listB.addAll(listA); нет реализации итератора, поэтому будет валиться на нульпоинтере
        listB.addAll(test);
        System.out.println(listB);
*/
//Check Task C
        //SetC <Short> set = new SetC<>();

        SetC<Short> myset = new SetC<>();

        Set<Short> set2 = new HashSet<>();
        /*set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");
        set.toString();
        System.out.println(set);

        System.out.println("проверка метода контэйнс (д.б. тру): " + set.contains("1"));
        System.out.println("проверка метода контэйнс (д.б. фолс): " + set.contains("10"));
        System.out.println("проверка адд (д.б. фолс): " + set.add ("2"));
        System.out.println("размер сэта: " + set.size());
        System.out.println("сэт пустой? " + set.isEmpty());
        System.out.println("удаление объекта из сэта: " + set.remove("3"));
*/

        for (int i = 0; i < 10; i++) {
            myset.add(i * 2);
            set2.add((short) (i * 2));
        }

        List<Short> added = new ArrayList<>();
        added.add(null);
        added.add(null);
        added.add((short) 1000);
        added.add((short) 1000);
        added.add((short) 1001);
        added.add((short) 1002);

        myset.addAll(added);
        set2.addAll(added);

        System.out.println("-----------добавили все------------");
        System.out.println();
        System.out.println(myset);
        System.out.println(set2);

        System.out.println("my - " + myset.size());
        System.out.println("set - " + set2.size());

        myset.removeAll(added);
        set2.removeAll(added);

        System.out.println("-----------удалили все------------");
        System.out.println();
        System.out.println(myset);
        System.out.println(set2);

        System.out.println("my - " + myset.size());
        System.out.println("set - " + set2.size());

    }
}
