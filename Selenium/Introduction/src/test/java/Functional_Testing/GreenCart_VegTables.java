package Functional_Testing;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenCart_VegTables {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		int j = 0;
		String[] itemsNeeded = {"Cucumber","Carrot","Corn","Apple"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i=0; i<products.size(); i++) {
			//Cucumber - 1 Kg
			//Cucumber,    1 kg
			String[] name = products.get(i).getText().split("-");
			String formatedName = name[0].trim();
			//format it to get actual vegetable name
			//convert array into array list for easy search
			//  check whether name you extracted is present in arrayList or not-
			List itemsNeededList = Arrays.asList(itemsNeeded);
			if (itemsNeededList.contains(formatedName)) {
				//click on Add to cart
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==itemsNeeded.length) {
					break;
				}
			}
		}
	}
}