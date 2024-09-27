package Section10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Iframes {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
//		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		System.out.println(driver.findElement(By.id("draggable")).getText());
		Actions act = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement destination = driver.findElement(By.id("droppable"));
		act.dragAndDrop(source, destination).build().perform();
		driver.switchTo().defaultContent();
	}
}
