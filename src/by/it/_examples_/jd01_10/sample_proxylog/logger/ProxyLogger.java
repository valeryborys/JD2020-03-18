package by.it._examples_.jd01_10.sample_proxylog.logger;

import by.it._examples_.jd01_10.sample_proxylog.Sender;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyLogger {

    public static Sender getLoggedSender(Sender target) {
        return (Sender) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                getInvocationHandler(target)
        );
    }

    private static InvocationHandler getInvocationHandler(Sender target) {
        return (proxy, proxyMethod, args) -> {
            Method method = target.getClass().getMethod(
                    proxyMethod.getName(), (Class<?>[]) proxyMethod.getGenericParameterTypes());
            if (method.isAnnotationPresent(Log.class)) {
                log(method);
                return method.invoke(target, args);
            } else
                throw new InvocationTargetException(null, String.format("method %s should be annotated ", method));
        };
    }

    private static void log(Method method) {
        Log a = method.getAnnotation(Log.class);
        System.out.printf("\033[32mLevel:%-10s\033[0m Name: %-20s LOG: %s\n",
                a.level(), method.getName(), a.text()
        );
    }

}
