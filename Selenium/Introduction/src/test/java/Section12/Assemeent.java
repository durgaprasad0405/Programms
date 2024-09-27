package Section12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assemeent {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		driver.findElement(By.id("product"));
		
		int sum = 0;
		List<WebElement> total = driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));
		
		for (int i=0; i<total.size(); i++) {
			sum = sum+Integer.parseInt(total.get(i).getText());
		}
		System.out.println(sum);
	}

}
