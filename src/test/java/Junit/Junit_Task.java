package Junit;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Junit_Task {
	static WebDriver driver;
	@Test
	public void method1() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("Start-maximized");
		options.addArguments("disable-popups");
		 driver = new ChromeDriver(options);
		 driver.get("https://www.google.co.in/");
		 	}
	@Test
	public void method2() {
	WebElement search =	driver.findElement(By.xpath("//*[@class='gLFyf']"));
	driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	search.sendKeys("Myntra" + Keys.ENTER);	
	driver.findElement(By.xpath("//*[@class='x2VHCd OSrXXb ob9lvb']")).click();
	}
	


	
}
