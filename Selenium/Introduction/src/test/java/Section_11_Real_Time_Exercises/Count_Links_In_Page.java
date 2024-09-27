package Section_11_Real_Time_Exercises;


import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Count_Links_In_Page {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//		1. Give me the count of links on the page
		System.out.println(driver.findElements(By.tagName("a")).size());
//		2. Count of footer section
		WebElement footerDriver = (driver.findElement(By.id("gf-BIG")));  
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		WebElement coloumnDriver = footerDriver.findElement(By.xpath("//div/table/tbody/tr/td[1]/ul"));
		System.out.println(coloumnDriver.findElements(By.tagName("a")).size());
//		4. Chick on each links in the coloumn and chick if the pages are opening
		
		for(int i=1;i<coloumnDriver.findElements(By.tagName("a")).size();i++) {
			String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			coloumnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
//			Thread.sleep(5000L);	
		}
//		opens all the tabs
		Set<String> abc=driver.getWindowHandles();//4
		Iterator<String> it=abc.iterator();
		while(it.hasNext())
		{	
		   driver.switchTo().window(it.next());
		   System.out.println(driver.getTitle());
		
		}
	}

}
