package ImplicitAndExplicitWait;

import java.sql.Driver;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class ImplicitWait {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		String[] itemsNeeded = {"Cucumber","Carrot","Corn","Apple"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		addItems(driver,itemsNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span.promoInfo")).getText(), "Code applied ..!");
		

	}
	public static void addItems(WebDriver driver, String[] itemsNeeded) {

		int j = 0;
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
