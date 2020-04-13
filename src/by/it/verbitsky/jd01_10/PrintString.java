package by.it.verbitsky.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class PrintString {
    public static void main(String[] args) {
        runTaskB2();
    }

    private static void runTaskB2() {
        Class<?> clazz = String.class;
        printNonStaticMethods(clazz.getDeclaredMethods());
    }

    private static void printNonStaticMethods(Method[] declaredMethods) {
        for (Method method : declaredMethods) {
            if (!Modifier.isStatic(method.getModifiers())) {
                System.out.printf("%s\n", method.getName());
            }
        }
    }
}
