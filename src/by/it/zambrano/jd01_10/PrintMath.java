package by.it.zambrano.jd01_10;

import java.lang.reflect.*;

class PrintMath {
        public static void main(String[] args) {
            Class<Math> labMathClass = Math.class;
            Method[] methods = labMathClass.getMethods();
            Field[] fields = labMathClass.getFields();
            for (Field field : fields) {
                System.out.print(field.getType() + " ");
                System.out.println(field.getName());
            }
            for (Method method : methods) {
                if (Modifier.isPublic(method.getModifiers())) System.out.print("public ");
                if (Modifier.isStatic(method.getModifiers())) System.out.print("static ");
                String retrunName = method.getReturnType().getName();
                String methodName = method.getName();
                Class<?>[] parameterTypes = method.getParameterTypes();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < parameterTypes.length; i++) {
                    if(i < parameterTypes.length - 1){
                        sb.append(parameterTypes[i].getSimpleName()).append(",");
                    }else{
                        sb.append(parameterTypes[i].getSimpleName());
                    }
                }
                System.out.printf("%s %s(%s)\n", retrunName, methodName, sb);
            }
        }
    }
