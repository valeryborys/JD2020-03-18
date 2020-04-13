package by.it.gutkovsky.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class PrintMath {
    public static void main(String[] args) {
        Class<?> mathClass = Math.class;
        Method[] declaredMethods = mathClass.getDeclaredMethods();

        // получение всех публичных методов
        for (Method declaredMethod : declaredMethods) {
            int modifiers = declaredMethod.getModifiers(); // получение модификатора метода
//            System.out.println(modifierToString);
            if (Modifier.isPublic(modifiers)) {
                String modifierToString = Modifier.toString(modifiers);
                String methodName = declaredMethod.getName(); // имя метода
                String returnName = declaredMethod.getReturnType().getName(); // получаем имя возвращаемоего: getReturnType() - ссылка на клас, getName() - само имя
//                System.out.printf("%d %s %s()\n",modifiers, returnName, methodName); // пример вывода: 9 int abs()
                Class<?>[] parameterTypes = declaredMethod.getParameterTypes();// параметры всех методов
                StringBuilder arg = new StringBuilder(); //  преобразуем параметры всех методов в String
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (parameterTypes.length == 1) {
                        arg.append(parameterTypes[i].getSimpleName());
                    } else {
                        if (parameterTypes.length > 1) {
                            if (i == (parameterTypes.length - 1)) {
                                arg.append(parameterTypes[i].getSimpleName());
                            } else {
                                arg.append(parameterTypes[i].getSimpleName()).append(",");
                            }
                        }
                    }
                }
                System.out.printf("%s %s %s(%s)\n", modifierToString, returnName, methodName, arg); // пример вывода: 9 int abs(int,)
            }
        }

        // получение публичных полей и их типов
        Field[] declaredFields = mathClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            int fieldModifier = declaredField.getModifiers();
            if (Modifier.isPublic(fieldModifier)) {
                String fieldName = declaredField.getName();
                Class<?> fieldType = declaredField.getType();
                System.out.println(fieldType + " " + fieldName);
            }
        }
    }
}
