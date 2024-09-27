package Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SelectDDClicks {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000L);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		int i = 1;
		while (i<5) {
			
			driver.findElement(By.id("hrefIncAdt")).click();
			System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
			i++;
		}	
//		for (int j=1; j<5; j++) {
//			
//			driver.findElement(By.id("hrefIncAdt")).click();
//			System.out.println(driver.findElement(By.id("divpaxinfo")).getText());	
//		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		driver.quit();
	}
}