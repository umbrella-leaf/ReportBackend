package com.report.utils.annotations;

import javax.persistence.QueryHint;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyCustomQueryHint {
    QueryHint[] value() default {@QueryHint(name = "org.hibernate.cacheable", value = "true")};

    boolean forCounting() default true;
}

