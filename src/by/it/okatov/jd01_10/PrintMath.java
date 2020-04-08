package by.it.okatov.jd01_10;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;


public class PrintMath {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Class<?> aClass = Math.class;
        Method[] methods = aClass.getMethods();
        Field[] fields = aClass.getDeclaredFields();
        reflectionGetMethods(sb, methods);
        reflectionGetFields(fields);
    }

    private static void reflectionGetFields(Field[] fields) {
        StringBuilder sb;
        sb = new StringBuilder();
        int mod;
        String varType;
        System.out.println("Fields: ");
        for (Field f : fields) {
            mod = f.getModifiers();
            varType = f.getType().toString();

            if (Modifier.isPublic(mod) && Modifier.isStatic(mod)) {
                sb.append(Modifier.toString(mod)).append(" ").append(varType).append(" ").append(f.getName()).append(";");
            }

            System.out.println(sb);
            sb = new StringBuilder();
        }
    }

    private static void reflectionGetMethods(StringBuilder sb, Method[] methods) {
        int mod;
        String returnType;
        Class<?>[] argTypes;


        for (Method m : methods) {

            mod = m.getModifiers();
            returnType = m.getReturnType().getSimpleName();
            argTypes = Arrays.copyOf(m.getParameterTypes(), m.getParameterCount());
            if (Modifier.isPublic(mod) && Modifier.isStatic(mod)) {
                sb.append(Modifier.toString(mod)).append(" ").append(returnType).append(" ").append(m.getName()).append("(");
                for (int i = 0; i < argTypes.length; i++) {
                    sb.append(argTypes[i].toString());
                    if (i + 1 == argTypes.length) {
                        break;
                    } else {
                        sb.append(",");
                    }
                }
                sb.append(");");
            }
            if (sb.length() == 0) {
                continue;
            } else {
                System.out.println(sb);
            }

            sb = new StringBuilder();
        }
    }

}
