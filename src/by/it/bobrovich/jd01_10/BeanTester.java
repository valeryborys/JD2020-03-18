package by.it.bobrovich.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Bean bean = null;
        Class<?> beanClass = Class.forName(Bean.class.getName());
        bean = (Bean) beanClass.newInstance();
        Method[] declaredMethods = beanClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            Annotation[] annotations = declaredMethod.getAnnotations();
            try{
                if(annotations[0] != null){
                    Param param = (Param) annotations[0];
                    System.out.print(declaredMethod.getName() + " ");
                    Object invoke = declaredMethod.invoke(bean, param.a(), param.b());
                    System.out.println(invoke);
                }
            } catch (Exception e){
                System.out.println("Null");
            }
        }
    }
}
