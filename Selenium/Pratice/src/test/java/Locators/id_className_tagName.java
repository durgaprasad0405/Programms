package Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class id_className_tagName {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Kanna");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacadem");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.xpath("//p[@class='error']")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("prasad");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("hbsxyawsdbqjhWSBJHQBsiux");
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("+919642355987");
		driver.findElement(By.className("reset-pwd-btn")).click();
		String password1 = driver.findElement(By.className("infoMsg")).getText();
		
//		String password = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
//		String password = driver.findElement(By.xpath(null))
		System.out.println(password1);
		String [] passwordArray = password1.split("'");
		String password = passwordArray[1];
		System.out.println(password);
		driver.findElement(By.className("go-to-login-btn")).click();
		driver.findElement(By.id("inputUsername")).sendKeys("Kanna");
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		
//		driver.quit();
	}
}