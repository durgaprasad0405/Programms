package Introduction;

import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {
	
	public static void main(String[] args) {
		
		//To launch ChromeDriver
		//webdriver.chrome.drive	-->  Value of path
//		WebDriver driver = new ChromeDriver();
		
		//To launch Firefox
		//webdriver.gecko.driver	--> Value of path
//		WebDriver driver = new FirefoxDriver();
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.quit();
		
	}
}