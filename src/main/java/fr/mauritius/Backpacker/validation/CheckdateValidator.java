package fr.mauritius.Backpacker.validation;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckdateValidator implements ConstraintValidator<Checkdate, LocalDate> {

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {

	if (value == null) {
	    return false;
	}

	LocalDate newDate = LocalDate.now();

	return newDate.minusDays(1).isAfter(value);

    }

}
