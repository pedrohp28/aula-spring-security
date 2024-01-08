package com.example.aula6.validations;

import com.example.aula6.contraints.NomeCursoConstraint;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = NomeCursoConstraint.class)
public @interface  NomeCursoValidation {
    String message() default "Nome fora do padrão";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
