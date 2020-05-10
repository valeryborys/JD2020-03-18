package by.it.novikov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClazz = Bean.class;  // объект типа Класс

        Method[] methods = beanClazz.getDeclaredMethods();
        Object bean = beanClazz.newInstance();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param param = method.getAnnotation(Param.class);
                System.out.println(method.getName());
                if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC) {
                    System.out.println(method.invoke(null, param.a(), param.b()));
                } else {
                    System.out.println(method.invoke(bean, param.a(), param.b()));
                }
            }

        }
    }
}