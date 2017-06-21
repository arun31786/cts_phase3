package com.cognizant.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AccountNumberValidator implements
ConstraintValidator<AccountNumberConstraint, String> {

	private AccountNumberConstraint accountNumber;
  @Override
  public void initialize(AccountNumberConstraint accountNumber) {
	  this.accountNumber = accountNumber;
  }

  @Override
  public boolean isValid(String account, ConstraintValidatorContext cxt) {
	  int min = accountNumber.min();
	  int max = accountNumber.max();
	  
      return account != null && account.matches("[0-9]+")
        && (account.length() >= min) && (account.length() <= max);
  }

}