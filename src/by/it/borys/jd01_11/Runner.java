package by.it.borys.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        List<String> st = new ListB<>();
        List<String> mb = new ArrayList<>();
      //  LinkedList<int> lk = new LinkedList<int>();
        Set<String> hs = new SetC<>();
        st.add("one");
        st.add("two");
        st.add("three");
        st.add("four");
        mb.add("seven");
        mb.add("eight");
        mb.add("nine");
        mb.add("ten");
        //mb.remove(0);
       // st.addAll(mb);
      //  System.out.println(st.toString());
       // hs.add(null);
        hs.add("one");
        hs.add("five");
        hs.add("three");
        hs.add("one");
        hs.add("four");
        hs.add("five");
        hs.add(null);
        hs.add("nine");
        hs.add("nine");
        hs.add(null);
        hs.add("seven");
        hs.remove("three");
     //   hs.remove("one");
//        st.remove(0);
//        st.set(1,"set1");
//        st.add(1,"add1");
//        st.add(1,"add2");
      //  hs.addAll(mb);
        hs.removeAll(mb);
        System.out.println(hs.toString());
        System.out.println(hs.contains("eleven"));
        System.out.println(hs.size());
        System.out.println(hs.isEmpty());

    }
}
