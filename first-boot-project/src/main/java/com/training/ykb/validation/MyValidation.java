package com.training.ykb.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Retention(RUNTIME)
@Target({
          TYPE,
          FIELD,
          METHOD,
          PARAMETER
})
@Constraint(validatedBy = {
                            MyValidationImpl.class
})
public @interface MyValidation {

    String start();

    String end() default "";

    String message() default "String başlaması gereken şekilde başlamıyor";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
