package apiEngine;

public class Route {
	
    private static final String MAPS = "/maps";
    private static final String API = "/api";
    private static final String PLACE = "/place";
    private static final String JSON = "/json";
    
 
    public static String post(){
    	return MAPS + API + PLACE + "/add" + JSON;
    }

    public static String get(){ 
    	return MAPS + API + PLACE + "/get" + JSON;
    }

    public static String put(){ 
    	return MAPS + API + PLACE + "/update" + JSON;
    }

    public static String delete(){
    	return MAPS + API + PLACE + "/delete" + JSON; 
    }

}
