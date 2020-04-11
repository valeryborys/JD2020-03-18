package by.it.borys.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> st = new ListB<>();
        List<String> mb = new ListB<>();
        st.add("one");
        st.add("two");
        st.add("three");
        st.add("four");
        mb.add("seven");
        mb.add("eight");
        mb.add("nine");
//        st.remove(0);
//        st.set(1,"set1");
//        st.add(1,"add1");
//        st.add(1,"add2");
      //ArrayList<>;
        st.addAll(mb);
        System.out.println(mb.toString());
        System.out.println(st.toString());
    }
}
