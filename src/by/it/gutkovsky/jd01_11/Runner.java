package by.it.gutkovsky.jd01_11;

import java.util.ArrayList;
import java.util.List;

class Runner {
    public static void main(String[] args) {

        List<String> list = new ListA<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        System.out.println(list);
        System.out.println();

        System.out.println( "element 2 = " + list.get(2));
        System.out.println();
        System.out.println("remove element 2 = " + list.remove(2));
        System.out.println();
        System.out.println(list);



    }
}
