package by.it.akhmelev.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static void main(String[] args) {
        Class<?> classMath = Math.class;
        Method[] methods = classMath.getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                String methodName = method.getName();
                String returnName = method.getReturnType().getName();
                Class<?>[] parameterTypes = method.getParameterTypes();
                StringBuilder arg=new StringBuilder();
                for (Class<?> parameterType : parameterTypes) {
                    arg.append(parameterType.getSimpleName()).append(" ");
                }
                System.out.printf("%d %s %s(%s)\n", modifiers, returnName, methodName,arg);
            }
        }

    }
}
