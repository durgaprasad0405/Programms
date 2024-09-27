package Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement selectDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropDown = new Select(selectDropDown);
		dropDown.selectByIndex(2);
		System.out.println(dropDown.getFirstSelectedOption().getText());
		dropDown.selectByValue("USD");
		System.out.println(dropDown.getFirstSelectedOption().getText());
		dropDown.selectByVisibleText("INR");
		System.out.println(dropDown.getFirstSelectedOption().getText());
		
	}

}
