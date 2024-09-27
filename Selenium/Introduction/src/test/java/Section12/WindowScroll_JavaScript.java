package Section12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WindowScroll_JavaScript {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		int sum = 0;
		List<WebElement> value = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		for (int i=0; i<value.size(); i++) {
			
//			System.out.println(value.get(i).getText());
			sum = sum+Integer.parseInt(value.get(i).getText());
			
		}
//		System.out.println(driver.findElement(By.cssSelector(".totalAmount")).getText());
		int amount = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
//		String[] sep = amounts.split(":");
//		int amounts = Integer.parseInt(sep[1].trim());
//		System.out.println(amounts);
		System.out.println(sum);
		System.out.println(amount);
		Assert.assertEquals(amount, sum); 
	}
}
