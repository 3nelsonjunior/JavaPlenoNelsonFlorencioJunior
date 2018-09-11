package com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.validation.interfaceValidation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.validation.ColaboradorPostValidator;

@Constraint(validatedBy = ColaboradorPostValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ColaboradorPost { 
    String message() default "Erro de Validação!";
 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
 
    String value() default "";
}
