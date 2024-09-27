package Payloads;

import Pojos.AccountPojo;

public class AccountPayload {
	
	public static AccountPojo createAccountPayload() {
		
		AccountPojo createAccountPayload = new AccountPojo(); 
		createAccountPayload.setUserName("Prasad425");
		createAccountPayload.setPassword("Prasad@42");
		return createAccountPayload;
		
	}

}
