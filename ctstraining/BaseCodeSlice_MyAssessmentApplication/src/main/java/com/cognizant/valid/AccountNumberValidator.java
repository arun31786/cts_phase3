package com.cognizant.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AccountNumberValidator implements
ConstraintValidator<AccountNumberConstraint, String> {

  @Override
  public void initialize(AccountNumberConstraint accountNumber) {
  }

  @Override
  public boolean isValid(String accountField,
    ConstraintValidatorContext cxt) {
      return accountField != null && accountField.matches("[0-9]+")
        && (accountField.length() > 8);
  }

}