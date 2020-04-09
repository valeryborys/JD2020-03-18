package by.it.tolstik.jd01_10;

import java.lang.reflect.Method;

class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<?> beanClass = Bean.class;
        Object instance = beanClass.getDeclaredConstructor().newInstance();
        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param annotation = method.getAnnotation(Param.class);
                int a = annotation.a();
                int b = annotation.b();
                double result = (double) method.invoke(instance,a,b);
                System.out.println(method.getName() + " = " + result);
            }
        }

    }
}


