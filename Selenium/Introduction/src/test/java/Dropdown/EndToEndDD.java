package Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EndToEndDD {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000l);
		driver.findElement(By.xpath("(//a[@value='TIR']) [2]")).click();
		Thread.sleep(2000l);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000l);
		for (int i=1; i<5 ; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.cssSelector("input[value='Done']")).click();
		Thread.sleep(2000l);
		driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).click();
		Thread.sleep(2000l);
		driver.findElement(By.xpath("//option[@value='INR']")).click();
		Thread.sleep(2000l);
		driver.findElement(By.xpath("//label[@for='ctl00_mainContent_chk_friendsandfamily']")).click();
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		driver.quit();
//		driver.findElement(By.id(null)).click();
	}

}
