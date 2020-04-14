package by.it.borys.jd01_11;

import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        List<String> st = new ListB<>();
        List<String> mb = new ListB<>();
      //  LinkedList<int> lk = new LinkedList<int>();
     //   Set<String> hs = new SetC<>();
        st.add("one");
        st.add("two");
        st.add("three");
        st.add("four");
        mb.add("seven");
        mb.add("eight");
        mb.add("nine");
        //mb.remove(0);
        st.addAll(mb);
        System.out.println(st.toString());
//        hs.add("one");
//        hs.add("five");
//        hs.add("three");
//        hs.add("one");
//        hs.add("four");
//        hs.add("five");
//        hs.add("nine");
////        st.remove(0);
//        st.set(1,"set1");
//        st.add(1,"add1");
//        st.add(1,"add2");
        //System.out.println(mb.toString());
    }
}
