package by.it.okatov.jd01_11;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ListA<>();
        List<String> ls = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("five");
        list.add("six");
        /*Set<String> sS = new HashSet<>();
        sS.add("sadas");
        sS.add("grrsf");
        sS.add("vsdvsd");
        sS.add("sareter");
        System.out.println(sS.add("sareter"));
        System.out.println(sS);

        Set<String> sS1 = new SetC<>();
        sS1.add("sadas");
        sS1.add("grrsf");
        sS1.add("vsdvsd");
        sS1.add("sareter");
        System.out.println(sS1.add("sareter"));
        System.out.println(sS1);
        ls.add("foo");
        ls.add("boo");
        ls.add("roo");
        ls.add("too");
        ls.add("goo");
        ls.add("koo");
        System.out.println("\nListA:");
        System.out.println(list);
        //list.add(3,"INSERT");
        System.out.println("\nListB: " + ls.size());
        System.out.println(ls);*/

        Set<Short> a = new SetC<>();
        Set<Short> e = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            e.add((short) (i * 2));
            a.add((short) (i * 2));
        }
        e.containsAll(a);
        System.out.println("\nSet A:");
        System.out.println(a);
        System.out.println("\nSet Original:");
        System.out.println(e);


        ls.addAll(list);
        System.out.println("\nListA + ListB:" + ls.size());

        System.out.println(ls);
    }
}
