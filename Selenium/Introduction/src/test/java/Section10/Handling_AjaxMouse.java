package Section10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Handling_AjaxMouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		Actions act = new Actions(driver);
		WebElement move = driver.findElement(By.id("small-searchterms"));
//		act.moveToElement(driver.findElement(By.cssSelector(".hover"))).build().perform();
		act.moveToElement(driver.findElement(By.id("small-searchterms"))).click().keyDown(Keys.SHIFT).sendKeys("ele").doubleClick().build().perform();
		act.moveToElement(move).contextClick().build().perform();

	}

}
