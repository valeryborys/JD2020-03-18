package by.it.gutkovsky.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] declaredMethods = stringClass.getDeclaredMethods();
//        for (Method declaredMethod : declaredMethods) { // вывод всех методов на печать для проверки
//            System.out.println(declaredMethod);
//        }
        for (Method declaredMethod : declaredMethods) {
            int modifiers = declaredMethod.getModifiers();
            if (!Modifier.isStatic(modifiers)) {
                String name = declaredMethod.getName();
                System.out.println(name);
            }
        }
    }
}
