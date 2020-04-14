package by.it.szamostyanin.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<?> beanClass = Bean.class;
        Object obj = null;
        double res;
        for (Method method : beanClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Param.class)) {
                Param par = method.getAnnotation(Param.class);
                try {
                    if (obj == null) {
                        obj = beanClass.getDeclaredConstructor().newInstance();
                    }
                    res = (double) method.invoke(obj, par.a(), par.b());
                    System.out.printf("%s %f\n",
                            method.getName(),
                            res);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}