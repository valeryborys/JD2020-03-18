package by.it.bobrovich.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Bean bean = null;
        Class<?> beanClass = Class.forName(Bean.class.getName());
        bean = (Bean) beanClass.newInstance();
        Method[] declaredMethods = beanClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            Annotation[] annotations = declaredMethod.getAnnotations();
            try {
                if (annotations[0] != null){
                    if(Modifier.isStatic(declaredMethod.getModifiers())){
                        //Bean.max();
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("NULL");
                break;
            }
        }
    }
}
