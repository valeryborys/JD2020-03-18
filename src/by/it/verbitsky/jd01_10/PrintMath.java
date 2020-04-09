package by.it.verbitsky.jd01_10;

import java.lang.reflect.*;

class PrintMath {
    public static void main(String[] args) {
        runTaskB1();
    }

    private static void runTaskB1() {
        Class<?> mathClass = Math.class;
        System.out.println("Публичные поля класса java.lang.Math");
        processFields(mathClass.getFields());
        System.out.println("\nПубличные методы класса java.lang.Math");
        processMethods(mathClass.getDeclaredMethods());
    }

    private static void processMethods(Method[] methods) {
        for (Method method : methods) {
            printMethod(method);
        }
    }

    private static void printMethod(Method m) {
        if (Modifier.isPublic(m.getModifiers())) {
            StringBuilder strParams = new StringBuilder();
            Class<?>[] parameterTypes = m.getParameterTypes();
            if (parameterTypes.length > 0) {
                for (Class<?> p : parameterTypes) {
                    strParams.append(p).append(",");
                }
                strParams.deleteCharAt(strParams.length() - 1);
            }

            System.out.printf("%s %s %s(%s)\n",
                    Modifier.toString(m.getModifiers()),
                    m.getReturnType().getCanonicalName(),
                    m.getName(),
                    strParams);
        }
    }

    private static void processFields(Field[] fields) {
        for (Field f : fields) {
            printField(f);
        }
    }

    private static void printField(Field f) {
        System.out.printf("%s %s %s\n",
                Modifier.toString(f.getModifiers()),
                f.getType().getCanonicalName(),
                f.getName());
    }

}
