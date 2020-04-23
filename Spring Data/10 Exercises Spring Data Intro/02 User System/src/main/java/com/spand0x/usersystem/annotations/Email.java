package com.spand0x.usersystem.annotations;

import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Component
@Constraint(validatedBy = EmailValidator.class)
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {

    int minUserNameLength() default 1;

    int maxUserNameLength() default 50;

    int maxHostNameLength() default 50;

    String regex() default "^([a-zA-Z0-9][-_.]?)*[a-zA-Z0-9]@([a-zA-Z][-]?)*[a-zA-Z](\\.([a-zA-Z][-]?)*[a-zA-Z])+$";

}