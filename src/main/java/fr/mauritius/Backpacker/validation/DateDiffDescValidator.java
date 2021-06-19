package fr.mauritius.Backpacker.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fr.mauritius.Backpacker.domain.dtos.CkbookingCreate;

public class DateDiffDescValidator implements ConstraintValidator<DateDiffDesc, CkbookingCreate> {

    @Override
    public boolean isValid(CkbookingCreate value, ConstraintValidatorContext context) {

	return value.getDateBegin().minusDays(0).isBefore(value.getDateEnd());

    }
}
