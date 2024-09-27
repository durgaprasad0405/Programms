package Resources;

public enum APIResource {
	
	post_reg("/api/register"),
	post_login("/api/login"),
	post_user("/api/users"),
	get_user_by_id("/api/users/{id}"),
	get_user_by_page("/api/users"),//?page=2
	put_user("/api/users/{id}"),
	patch_use("/api/users/{id}"),
	delete_user("/api/users/{id}"),
	post_logout("/api/login"),
	post_unreg("/api/register");
	
	public String resource;
	
	APIResource(String resource){
		this.resource=resource;
	}
	public String getResource() {
		return resource;
	}
}