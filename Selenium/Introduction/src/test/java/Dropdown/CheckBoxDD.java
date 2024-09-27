package Dropdown;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxDD {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Xpath	-> //input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']
		//Css	-> input[id*='SeniorCitizenDiscount']
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		//count the no of checkboxes
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());


	}

}
