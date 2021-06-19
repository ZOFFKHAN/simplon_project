package fr.mauritius.Backpacker.validation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
//@Target(FIELD)
@Target(ElementType.FIELD)
@Constraint(validatedBy = { UniquemailValidator.class })
public @interface Uniquemail {

    String message() default "Nick name doit être unique}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
