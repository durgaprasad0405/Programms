package Resources;

public class Endpoints {
	
	public static String base_url = "https://reqres.in";
	
	public static String post_reg = "/api/register";
	public static String post_login = "/api/login";
	public static String post_user = "/api/users";
	public static String get_user_by_id = "/api/users/{id}";
	public static String get_user_by_page = "/api/users";//?page=2
	public static String put_user = "/api/users/{id}";
	public static String patch_user = "/api/users/{id}";
	public static String delete_user = "/api/users/{id}";
	public static String post_logout = "/api/login";
	public static String post_unreg = "/api/register";
//	public static String post_ = "";
}
