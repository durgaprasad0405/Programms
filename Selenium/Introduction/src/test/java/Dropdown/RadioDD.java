package Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioDD {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.println(driver.findElements(By.cssSelector("input[type='radio']")).size());
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_0']")).isEnabled();
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).isSelected();
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_2']")).click();
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_2']")).isSelected();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='MultiCityModelAlert']")).click();
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).click();
	}
}
