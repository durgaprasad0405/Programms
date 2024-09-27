package Resources;

import Pojo.CreateUserPojo;
import Pojo.RegAndLoginPojo;

public class TestDataBuilder {
	
	public RegAndLoginPojo regAndLoginPayload(String email, String password) {
		
		RegAndLoginPojo regAndLoginPayload = new RegAndLoginPojo();
		regAndLoginPayload.setEmail(email);
		regAndLoginPayload.setPassword(password);
		return regAndLoginPayload;	
	}
	
	public CreateUserPojo createUserPayload(String name, String job) {
		CreateUserPojo createUserPayload = new CreateUserPojo();
		createUserPayload.setName(name);
		createUserPayload.setJob(job);
		return createUserPayload;
	}
}
