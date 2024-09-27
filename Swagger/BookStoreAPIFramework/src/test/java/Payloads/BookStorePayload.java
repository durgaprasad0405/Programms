package Payloads;

import java.util.ArrayList;
import java.util.List;

import Pojos.BookStoreAccountPojo;
import Pojos.BookStorePojo;
import Pojos.collectionOfIsbns;
import TestRunners.BookStoreTest;

public class BookStorePayload {
	
	public static BookStorePojo createBookStorePayload() {
		
		BookStorePojo createBookStorePayload = new BookStorePojo(); 
		createBookStorePayload.setUserId(BookStoreTest.userID);
		
		collectionOfIsbns collISBN= new collectionOfIsbns();
		collISBN.setIsbn("9781491904244");
		List<collectionOfIsbns> collection = new ArrayList<collectionOfIsbns>();
		collection.add(collISBN);
		createBookStorePayload.setCollectionOfIsbns(collection);
		
		return createBookStorePayload;
		
	}
	public static BookStoreAccountPojo createBookStoreAccountPayload() {
		
		BookStoreAccountPojo createBookStoreAccountPayload = new BookStoreAccountPojo(); 
		createBookStoreAccountPayload.setUserName("Prasad424536");
		createBookStoreAccountPayload.setPassword("Prasad@42");
		return createBookStoreAccountPayload;
		
	}

}
