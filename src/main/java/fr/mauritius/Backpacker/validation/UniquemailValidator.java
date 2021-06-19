package fr.mauritius.Backpacker.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fr.mauritius.Backpacker.repositories.AccountRepository;

public class UniquemailValidator implements ConstraintValidator<Uniquemail, String> {
//public class UpperCaseValidator implements ConstraintValidator<A, T> {

    private final AccountRepository accounts;

    public UniquemailValidator(AccountRepository accounts) {

	this.accounts = accounts;
    }

//A annotation
// T par le type cible
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

	if (value == null) {
	    return true;
	}
	return !accounts.existsByUsername(value);

    }
}
