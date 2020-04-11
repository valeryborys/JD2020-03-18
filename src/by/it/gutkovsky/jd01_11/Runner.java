package by.it.gutkovsky.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Runner {
    public static void main(String[] args) {
/*
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        List<String> list2 = new ListB<>();
        list2.add("one");
        list2.add("two");
        list2.add("three");
        list2.add("four");
        list2.add("five");

        List<String> insertList = new ArrayList<>();
        insertList.add("Ola");
        insertList.add("Masha");

        System.out.println("ArrayList " + list);
        System.out.println("ListB " + list2);
        System.out.println();
        System.out.println("get element 2 ArrayList = " + list.get(2));
        System.out.println("get element 2 ListB = " + list2.get(2));
        System.out.println();
        System.out.println("remove element 2 ArrayList = " + list.remove(2));
        System.out.println("remove element 2 ListB = " + list2.remove(2));
        System.out.println();
        System.out.println("Result after remove ArrayList " + list);
        System.out.println("Result after remove ListB " + list2);
        System.out.println();
        System.out.println("set for ArrayList : " + list.set(2, "Dima"));
        System.out.println("ArrayList after set : " + list);
        System.out.println("set for ListB : " + list2.set(2, "Dima"));
        System.out.println("ListB after set : " + list2);
        System.out.println();
        System.out.println("ArrayList addAll insertList : " + list.addAll(insertList));
        System.out.println("ArrayList addAll insertList result : " + list);
        System.out.println("ListB addAll insertList : " + list2.addAll(insertList));
        System.out.println("ListB addAll insertList result : " + list);
        System.out.println();
        System.out.println("ArrayList size : " + list.size());
        System.out.println("ListB size : " + list.size());
        System.out.println();
        System.out.println("ArrayList indexof Dima is : " + list.indexOf("Dima"));
        System.out.println("ListB indexof Dima is : " + list.indexOf("Dima"));
        System.out.println();
        System.out.println(("ArrayList remove index 1 : " + list.remove(1) + " " + list));
        System.out.println(("ListB remove index 1 : " + list2.remove(1) + " " + list2));
        System.out.println();
        System.out.println("ArrayList contains Dima? : " + list.contains("Dima"));
        System.out.println("ListB contains Dima? : " + list2.contains("Dima"));

 */
        Set<Short> set = new HashSet<>();

//        set.add("one");
//        set.add("");
//        set.add("");
//        set.add("four");
//        set.add("one");

        Set<Short> mySet = new SetC<>();
//        mySet.add("one");
//        mySet.add("");
//        mySet.add("");
//        mySet.add("four");
//        mySet.add("one");

        for (int i = 0; i < 10; i++) {
            set.add((short) (i * 2));
            mySet.add((short) (i * 2));
        }
//        set.add(null);
//        mySet.add(null);

        System.out.println(set);
        System.out.println(mySet);
        System.out.println();
        System.out.println(set.size());
        System.out.println(mySet.size());
        System.out.println();
        System.out.println("set contains 2? : " + set.contains(2));
        System.out.println("mySet contains 2? : " + mySet.contains(2));
        List<Short> added = new ArrayList<>();
        added.add(null);
        added.add(null);
        added.add((short) 1000);
        added.add((short) 1000);
        added.add((short) 1001);
        added.add((short) 1002);
        System.out.println("Set : test addAll : " + set.addAll(added) + " : " + set + " size : " + set.size());
        System.out.println("mySet : test addAll : " + mySet.addAll(added) + " : " + mySet + " size : " + mySet.size() );
        System.out.println();
        System.out.println("removeAll test: set : " + set.removeAll(added) + " : " + set);
        System.out.println("removeAll test: mySet : " + mySet.removeAll(added) + " : " + mySet);
        System.out.println();
        set.clear();
        mySet.clear();
        System.out.println("test clear: set : " + set.size());
        System.out.println("test clear: MySet : " + mySet.size());



    }
}
