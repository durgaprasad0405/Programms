package Payloads;

import Pojos.Data;
import Pojos.ObjectPojo;

public class ObjectPayload {
	
	public static ObjectPojo createObjectPayload() {
		
		ObjectPojo createObjectPayload = new ObjectPojo();
		createObjectPayload.setName("HP ProBook");
		Data data = new Data();
		data.setYear(2024);
		data.setPrice(42842);
		data.setCupModel("intel core i5");
		data.setHardDiskSize("1TB");
		createObjectPayload.setData(data);
		return createObjectPayload;
		
	}
	
public static ObjectPojo updateObjectPayload() {
		
		ObjectPojo updateObjectPayload = new ObjectPojo();
		updateObjectPayload.setName("HP ProBook max");
		Data data = new Data();
		data.setYear(2025);
		data.setPrice(82842);
		data.setCupModel("intel core i9");
		data.setHardDiskSize("10TB");
		updateObjectPayload.setData(data);
		return updateObjectPayload;
		
	}

}
