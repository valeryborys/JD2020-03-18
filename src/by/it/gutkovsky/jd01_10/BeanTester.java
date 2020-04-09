package by.it.gutkovsky.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class BeanTester {
    public static void main(String[] args) throws Exception {

        Class<?> beanClass = Bean.class;

        Constructor<?> declaredConstructor = beanClass.getDeclaredConstructor();
        Object o = declaredConstructor.newInstance(); // создание объекта

        Method[] declaredMethods = beanClass.getDeclaredMethods();
//        for (Method declaredMethod : declaredMethods) {  // вывод всех методов на печать
//            String methodName = declaredMethod.getName();
//            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
//            String returnType = declaredMethod.getReturnType().getSimpleName();
//            System.out.printf("%s %s(%s)\n", returnType, methodName, Arrays.toString(parameterTypes));
//        }

        for (Method declaredMethod : declaredMethods) {
//            Annotation[] declaredAnnotations = declaredMethod.getDeclaredAnnotations(); // вывод на печать всех Аннтотаций для методов
//            for (Annotation declaredAnnotation : declaredAnnotations) {
//                System.out.println(declaredAnnotation);
//            }
            if (declaredMethod.isAnnotationPresent(Param.class)) {
                String methodName = declaredMethod.getName(); // получаю имя метода
                Param annotation = declaredMethod.getAnnotation(Param.class); // получение значений аннотации
                int aValue = annotation.a();
                int bValue = annotation.b();
                double methodResult = (double) declaredMethod.invoke(o,aValue, bValue); // вычисление работы метода
                System.out.println(methodName + " = " + methodResult);
                }
        }
    }
}
