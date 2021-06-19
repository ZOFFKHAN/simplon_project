package fr.mauritius.Backpacker.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target({ FIELD, LOCAL_VARIABLE })
@Constraint(validatedBy = { CheckdateValidator.class })
public @interface Checkdate {
    String message() default "date doit être supérieur à aujourd'hui}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
