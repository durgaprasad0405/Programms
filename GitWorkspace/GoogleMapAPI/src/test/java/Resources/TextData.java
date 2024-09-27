package Resources;

public class TextData {
	
	
	public static String base_URL = "https://rahulshettyacademy.com";
	public static String qpValue = "qaclick123";
	public static String payload = "{\r\n"
			+ "    \"location\": {\r\n"
			+ "        \"lat\": -38.383494,\r\n"
			+ "        \"lng\": 33.427362\r\n"
			+ "    },\r\n"
			+ "    \"accuracy\": 40,\r\n"
			+ "    \"name\": \"Kanna House\",\r\n"
			+ "    \"phone_number\": \"(+91) 983 893 3937\",\r\n"
			+ "    \"address\": \"Kanna Colony, Kanna Street\",\r\n"
			+ "    \"types\": [\r\n"
			+ "        \"Kanna park\",\r\n"
			+ "        \"Kanna shop\"\r\n"
			+ "    ],\r\n"
			+ "    \"website\": \"http://Kanna.com\",\r\n"
			+ "    \"language\": \"Telugu-IN\"\r\n"
			+ "}";
	public static String payload(String PhoneNo) {

		return "{\r\n"
				+ "    \"location\": {\r\n"
				+ "        \"lat\": -38.383494,\r\n"
				+ "        \"lng\": 33.427362\r\n"
				+ "    },\r\n"
				+ "    \"accuracy\": 40,\r\n"
				+ "    \"name\": \"Kanna House\",\r\n"
				+ "    \"phone_number\": \""+PhoneNo+"\",\r\n"
				+ "    \"address\": \"Kanna Colony, Kanna Street\",\r\n"
				+ "    \"types\": [\r\n"
				+ "        \"Kanna park\",\r\n"
				+ "        \"Kanna shop\"\r\n"
				+ "    ],\r\n"
				+ "    \"website\": \"http://Kanna.com\",\r\n"
				+ "    \"language\": \"Telugu-IN\"\r\n"
				+ "}";
	}
	public static String deletePayload(String placeId) {

		return "{\r\n"
				+ "    \"place_id\": \""+placeId+"\"\r\n"
				+ "}";
	}
	public static String putPayload(String placeId, String no) {

		return "{\r\n"
				+ "    \"place_id\": \""+placeId+"\",\r\n"
				+ "    \"address\": \""+no+" Summer walks, USA\",\r\n"
				+ "    \"key\": \"qaclick123\"\r\n"
				+ "}";
	}
	

}
