package org.chiwooplatform.simple.message;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
public @interface JsonMessage {

    // JsonRootName name();
    String value() default "";
}
