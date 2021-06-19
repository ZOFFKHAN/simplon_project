package fr.mauritius.Backpacker.validation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(ElementType.TYPE)

@Constraint(validatedBy = { DateDiffDescValidator.class })
public @interface DateDiffDesc {

    String message() default "date de fin doit être après date de début";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}