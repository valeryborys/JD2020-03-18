package by.it.tolstik.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;

class PrintMath {
    public static void main(String[] args) {
        Class<?> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {

                String methodName = method.getName();
                String returnTypeName = method.getReturnType().getName();
                Parameter[] parameters = method.getParameters();
                String mod = Modifier.toString(modifiers);
                System.out.printf("%s %s %s(%s)\n", mod, returnTypeName, methodName, Arrays.toString(parameters)
                        .replaceAll("arg.", "").replaceAll("\\[", "")
                        .replaceAll("\\]", "").replaceAll("\\s", ""));
            }
        }
        Field[] fields = mathClass.getFields();
        for (Field field : fields) {
            Class<?> type = field.getType();
            System.out.printf("%s %s\n", type.getSimpleName(), field.getName());
        }

    }
}
