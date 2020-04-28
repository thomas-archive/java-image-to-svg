package com.trikthom.image_to_SVG.annotations;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Attribute {
    String value() default "";
}
