package by.it.verbitsky.jd01_10;

import java.lang.reflect.Method;
import java.util.Locale;

class BeanTester {
    public static void main(String[] args) throws Exception {
        runTaskC1();
    }

    private static void runTaskC1() {
        Class<?> clazz = Bean.class;
        Object object = null;
        double result;
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Param.class)) {
                //проверим, есть ли аннотация Param  на методе класса Bean
                //Если да, то получаем ее:
                Param ann = method.getAnnotation(Param.class);
                //если объект еще не создавался - создадим его
                //иначе будем юзать уже созданный
                try {
                    if (object == null) {
                        object = clazz.getDeclaredConstructor().newInstance();
                    }
                    //запускаем метод на созданном объекте object
                    result = (double) method.invoke(object, ann.a(), ann.b());
                    System.out.printf(Locale.ENGLISH, "Запуск метода: %s = %3.1f\n", method.getName(), result);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
