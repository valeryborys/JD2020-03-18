package by.it.szamostyanin.jd01_10;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        Field [] fields = mathClass.getFields();
        PrintFieldsMath(fields);
        PrintMethodsMath(methods);
    }

    private static void PrintFieldsMath(Field[] fields) {
        for (Field field : fields) {
            System.out.printf("%s %s\n",
                    field.getType().getSimpleName(),
                    field.getName());
        }
    }

    private static void PrintMethodsMath(Method[] methods) {
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                StringBuilder types = new StringBuilder();
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length > 0) {
                    for (Class<?> param : parameterTypes) {
                        types.append(param).append(',');
                    }
                    types.deleteCharAt(types.length() - 1);
                }
                System.out.printf("%s %s %s(%s)\n",
                        Modifier.toString(method.getModifiers()),
                        method.getReturnType().getSimpleName(),
                        method.getName(),
                        types);
            }
        }
    }
}
