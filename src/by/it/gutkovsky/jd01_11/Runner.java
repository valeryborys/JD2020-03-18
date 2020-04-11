package by.it.gutkovsky.jd01_11;

import java.util.ArrayList;
import java.util.List;

class Runner {
    public static void main(String[] args) {

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


    }
}
