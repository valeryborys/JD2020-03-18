package by.it.lemesh.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<?> beanClass = Bean.class;
        Class<?> paramClass = Param.class;
        Method method1 = paramClass.getMethod("a");
        Method method2 = paramClass.getMethod("b");
        Constructor<?> constructor = beanClass.getConstructor();
        Bean bean1 = (Bean) constructor.newInstance();
        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param annotation = method.getAnnotation(Param.class);
                int value1 = (int) method1.invoke(annotation);
                int value2 = (int) method2.invoke(annotation);
                String name = method.getName();
                double res = (double) method.invoke(bean1, value1, value2);
                System.out.println(name + " результат = " + res);
            }
        }
    }
}
