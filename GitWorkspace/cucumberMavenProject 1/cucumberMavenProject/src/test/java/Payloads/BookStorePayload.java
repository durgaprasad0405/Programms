package Payloads;

import java.util.ArrayList;
import java.util.List;

import Pojos.BookStoreAccountPojo;
import Pojos.BookStorePojo;
import Pojos.collectionOfIsbns;

public class BookStorePayload {
	
	public static BookStorePojo createBookStorePayload() {
		
		BookStorePojo createBookStorePayload = new BookStorePojo(); 
		createBookStorePayload.setUserId("0b4dc5d2-6a5e-4a9d-a34c-b10fd4130b5f");
		
		collectionOfIsbns collISBN= new collectionOfIsbns();
		collISBN.setIsbn("9781449365036");
		List<collectionOfIsbns> collection = new ArrayList<collectionOfIsbns>();
		collection.add(collISBN);
		createBookStorePayload.setCollectionOfIsbns(collection);
		
		return createBookStorePayload;
		
	}
	public static BookStoreAccountPojo createBookStoreAccountPayload() {
		
		BookStoreAccountPojo createBookStoreAccountPayload = new BookStoreAccountPojo(); 
		createBookStoreAccountPayload.setUserName("Kanna128467");
		createBookStoreAccountPayload.setPassword("Kanna@12");
		return createBookStoreAccountPayload;
		
	}

}
