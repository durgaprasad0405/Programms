package Locators;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dropdown {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//To select the Auto suggestive dropdown
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		List<WebElement> countryOptions = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for (WebElement option : countryOptions) {
			if (option.getText().equalsIgnoreCase("India")) {
				System.out.println("India was selected");
				option.click();
				break;	
			}
		}
		
		//To select radio buttons
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		System.out.println(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).getText());
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		
		//To select 
		
	}
	
	
}
