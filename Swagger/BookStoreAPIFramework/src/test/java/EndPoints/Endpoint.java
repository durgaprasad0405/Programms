package EndPoints;

public class Endpoint {
	
	//BookStore Base URL		//https://bookstore.toolsqa.com
	public static String Base_url = "https://bookstore.demoqa.com";
	
	//Account EndPoints
	public static String post_account = Base_url+"/Account/v1/User";
	public static String post_generate_token = Base_url+"/Account/v1/GenerateToken";
	public static String post_authorized = Base_url+"/Account/v1/Authorized";
	public static String get_account = Base_url+"/Account/v1/User/";
	public static String delete_account = Base_url+"/Account/v1/User/";
	
	//BookStore EnsPoints
	public static String post_book_account = Base_url+"/Account/v1/User";
	public static String post_create_book = Base_url+"/BookStore/v1/Books";
	public static String get_book = Base_url+"/BookStore/v1/Books";
	public static String get_book_isbn = Base_url+"/BookStore/v1/Book";
	public static String put_book = Base_url+"/BookStore/v1/Books/";
	public static String delete_book_userid = Base_url+"/BookStore/v1/Books";
	public static String delete_book_payload = Base_url+"/BookStore/v1/Book";

}
