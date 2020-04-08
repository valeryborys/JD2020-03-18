package by.it.gutkovsky.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<?> mathClass = Math.class;
        Method[] declaredMethods = mathClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            int modifiers = declaredMethod.getModifiers(); // получение модификатора метода
            if(Modifier.isPublic(modifiers)){
                String methodName = declaredMethod.getName(); // имя метода
                String returnName = declaredMethod.getReturnType().getName(); // получаем имя возвращаемоего: getReturnType() - ссылка на клас, getName() - само имя
//                System.out.printf("%d %s %S()\n",modifiers, returnName, methodName); // пример вывода: 9 int ABS()
                Class<?>[] parameterTypes = declaredMethod.getParameterTypes();// параметры всех методов
//                for (int i = 0; i < parameterTypes.length; i++) {
//                    System.out.println(parameterTypes[i]);
//
//                }
                StringBuilder arg = new StringBuilder(); //  преобра зуем параметры всех методов в String
                for (Class<?> parameterType : parameterTypes) {
//                    if (parameterType.len)
                    arg.append(parameterType.getSimpleName()).append(" ");

                    System.out.println(arg + " "  + arg.capacity());
//                    System.out.println(arg);
                }
//                System.out.printf("%d %s %s(%s)\n",modifiers, returnName, methodName, arg); // пример вывода: 9 int abs(int,)

            }


        }


    }
}
