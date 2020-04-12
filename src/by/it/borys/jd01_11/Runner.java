package by.it.borys.jd01_11;

import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.LinkedList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> st = new ListB<>();
        List<String> mb = new ArrayList<>();
      //  LinkedList<int> lk = new LinkedList<int>();
   //     HashSet<String> hs = new SetC<>();
        st.add("one");
        st.add("two");
        st.add("three");
        st.add("four");
        mb.add("seven");
        mb.add("eight");
        mb.add("nine");
        mb.remove(0);
//        hs.add("1");
//        hs.add("5");
//        hs.add("3");
//        hs.add("1");
//        hs.add("4");
//        hs.add("5");
//        st.remove(0);
//        st.set(1,"set1");
//        st.add(1,"add1");
//        st.add(1,"add2");
        //st.addAll(mb);
        //System.out.println(mb.toString());
        System.out.println(st.toString());
    }
}
