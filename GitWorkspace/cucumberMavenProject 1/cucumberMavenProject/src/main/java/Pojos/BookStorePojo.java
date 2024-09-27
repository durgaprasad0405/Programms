package Pojos;

import java.util.List;

public class BookStorePojo {
	
	public String userId;
	public List<collectionOfIsbns> collectionOfIsbns;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<collectionOfIsbns> getCollectionOfIsbns() {
		return collectionOfIsbns;
	}
	public void setCollectionOfIsbns(List<collectionOfIsbns> collectionOfIsbns) {
		this.collectionOfIsbns = collectionOfIsbns;
	}
	


}
