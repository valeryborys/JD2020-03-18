package by.it.borys.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.Math;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<?> aClass = Math.class;
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            int modifires = method.getModifiers();
            if (Modifier.isPublic(modifires)) {
                StringBuilder modifiresPrint = new StringBuilder();
                modifiresPrint.append("public ");
                if (Modifier.isStatic(modifires)) modifiresPrint.append("static");
                String name = method.getName();
                String returnType = method.getReturnType().getName();
                Class<?>[] parameterTypes = method.getParameterTypes();
                StringBuilder arg = new StringBuilder();
                String delimiter = "";
                for (Class<?> parameterType : parameterTypes) {
                    arg.append(delimiter).append(parameterType.getSimpleName());
                    delimiter = ",";
                }
                System.out.printf("%s %s %s(%s)\n",modifiresPrint,returnType, name, arg);
            }
            //System.out.println(method);
        }
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            int modifires = field.getModifiers();
            StringBuilder modifiresPrint = new StringBuilder();
            if(Modifier.isPublic(modifires)){
                modifiresPrint.append("public ");
            if(Modifier.isStatic(modifires)) modifiresPrint.append("static ");
            if(Modifier.isFinal(modifires)) modifiresPrint.append("final ");
            String name = field.getName();
            String returnType = field.getType().getName();
            System.out.printf("%s%s %s\n",modifiresPrint,returnType,name);
                }
          //  System.out.println(field);
        }

    }

}

