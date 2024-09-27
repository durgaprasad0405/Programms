package Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarDD {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//class="ui-state-default ui-state-highlight ui-state-active ui-state-hover"
		driver.findElement(By.name("ctl00$mainContent$view_date1")).click();
		Thread.sleep(2000);
		//.ui-state-default.ui-state-highlight.ui-state-hover
		//.ui-state-default.ui-state-highlight
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();
	}
}
