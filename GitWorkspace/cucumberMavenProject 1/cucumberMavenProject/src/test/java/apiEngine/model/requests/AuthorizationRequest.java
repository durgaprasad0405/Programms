package apiEngine.model.requests;

public class AuthorizationRequest {

	 public String userName;
	    public String password;

	    public AuthorizationRequest(String username, String password) 
	    {
	        this.userName = username;
	        this.password = password;
}
	    
	    public String location;
	    public String accuracy;
	    public String name;
	    public String phone_number;
	    public String address;
	    public String types;
	    
	    
}
