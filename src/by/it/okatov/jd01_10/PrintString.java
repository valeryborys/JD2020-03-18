package by.it.okatov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class PrintString {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Class<String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();
        int mod;

        for (Method m : methods) {
            mod = m.getModifiers();

            if (!Modifier.isStatic(mod)) {
                sb.append(m.getName());
            }

            if (sb.length() == 0) {
                continue;
            } else {
                System.out.println(sb);
            }

            sb = new StringBuilder();
        }
    }
}
