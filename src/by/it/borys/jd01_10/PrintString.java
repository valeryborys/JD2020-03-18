package by.it.borys.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<?> aClass = String.class;
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            int modifires = method.getModifiers();
            if (!Modifier.isStatic(modifires)){
                String name = method.getName();
                System.out.println(name);

            }
        }
    }
}
