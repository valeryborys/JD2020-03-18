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
//                System.out.println(methodName + " = " + methodResult); //обычный вывод
                System.out.printf("\033[32m method: \033[36m%s= \033[31m%s\n",methodName,methodResult); // цветной вывод
                /*
                \033 - далее символ отвечающий за цвет
                [30m - черный
                [31m - красный
                [32m - зеленый
                [33m - желтый
                [34m - синий
                [35m - пурпурный
                [36m - голубой
                [37m - белый.
                 */
                }
        }
    }
}
