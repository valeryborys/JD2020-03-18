package by.it.okatov.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {
    public static void main(String[] args) throws Exception {

        beanMethodsInvocation();
    }


    private static void beanMethodsInvocation()
            throws NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        Bean beanClass;
        int aVar; //Первый операнд аннотации Param
        int bVar; //Второй операнд аннотации Param
        double res; //Результат выполнения операции
        try {
            beanClass = (Bean) Class.forName(Bean.class.getName()).newInstance();//Находим класс и создаем его экземпляр
            Class<?> aClass = beanClass.getClass(); //Получаем переменную типа "Класс"
            Method[] methods = aClass.getDeclaredMethods();
            Class<? extends Annotation> annClass = Param.class; //Находим аннотацию

            //Находим параметры аннотации (объявляются как методы)
            Method a = annClass.getMethod("a");
            Method b = annClass.getMethod("b");

            //Конструктор класса, используемый для вызова нестатических методов
            Object constructor = aClass.getDeclaredConstructor().newInstance();

            for (Method m : methods) {
                if (m.isAnnotationPresent(Param.class)) {
                    Annotation annotation = m.getAnnotation(annClass);

                    //Вызываем методы аннотации (на самом деле просто получаем значения параметров)
                    aVar = (int) a.invoke(annotation);
                    bVar = (int) b.invoke(annotation);

                    if (Modifier.isStatic(m.getModifiers())) {
                        res = (double) m.invoke(null, aVar, bVar);
                    } else {
                        res = (double) m.invoke(constructor, aVar, bVar);
                    }
                    System.out.println("Method's name: " + m.getName() + "\nResult: " + res);
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }
}
