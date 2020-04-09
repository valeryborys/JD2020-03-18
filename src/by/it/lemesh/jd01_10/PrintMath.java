package by.it.lemesh.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<?> mathClass = Math.class;
        Method[] declaredMethods = mathClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            int modifiers = declaredMethod.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                String mod = "public ";
                if (Modifier.isStatic(modifiers)) {
                    mod = mod.concat("static");
                }
                String methodName = declaredMethod.getName();
                String returnName = declaredMethod.getReturnType().getName();
                Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
                StringBuilder arg = new StringBuilder();
                for (int k = 0; k < parameterTypes.length; k++) {
                    arg.append(parameterTypes[k].getSimpleName());
                    if ((parameterTypes.length - k) > 1) {
                        arg.append(",");
                    }
                }
                System.out.printf("%s %s %s(%s)\n", mod, returnName, methodName, arg);
            }
        }
        Field[] fields = mathClass.getFields();
        for (Field field : fields) {
            System.out.print(field.getType() + " " + field.getName() + "\n");
        }
    }
}
