package com.cognizant.validator;



public class ValidatedAccount {
//	@AccountNumberConstraint()
	@AccountNumberConstraint(message="Not a valid number", min=2, max=6)
	private String account;

	
	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	@Override
	public String toString() {
		return account;
	}

}
