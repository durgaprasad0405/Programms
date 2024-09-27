package Section10;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchParentToChaild {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		System.out.println(driver.findElement(By.cssSelector(".blinkingText")).getText());
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentIt = it.next();
		String chaildIt = it.next();
		driver.switchTo().window(chaildIt);
		String email = driver.findElement(By.cssSelector("a[href='mailto:mentor@rahulshettyacademy.com']")).getText();
		System.out.println(email);
		driver.switchTo().window(parentIt);
		driver.findElement(By.id("username")).sendKeys(email);
	}
}