package by.it.borys.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> cls = Bean.class;
        Method[] methods = cls.getDeclaredMethods();
        Object o = null;
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)){
                if (o==null){
                    o=cls.newInstance();
                }
              Param prm = method.getAnnotation(Param.class);
                System.out.println(method.invoke(o, prm.a() , prm.b() ));
                System.out.println(method.getName());

            }
        }


    }
}
