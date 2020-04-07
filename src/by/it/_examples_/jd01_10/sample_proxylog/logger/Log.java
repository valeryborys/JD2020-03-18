package by.it._examples_.jd01_10.sample_proxylog.logger;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Log {
    String text();

    Level level() default Level.INFO;
}
