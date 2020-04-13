package by.it.novikov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class PrintString {
    public static void main(String[] args) {
        Class<String> stringClazz = String.class;
        Method[] methods = stringClazz.getDeclaredMethods();
        for (Method method: methods) {
            if ((method.getModifiers() & Modifier.STATIC) != Modifier.STATIC){
                System.out.println(method.getName());
            }
        }

    }
}