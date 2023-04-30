package org.practice.miscellaneous.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RunThis {
    int value() default 0;
    boolean runOnlyThis() default true;
    int runOnLoop() default 1;
}
