package Junit;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	try {
	search.sendKeys("Myntra" + Keys.ENTER);	
	driver.findElement(By.xpath("//*[@class='x2VHCd OSrXXb ob9lvb']")).click();
	} catch(Exception e){
		e.printStackTrace();
	}
	}
	@Test
	public void method3() {
		WebElement category = driver.findElement(By.xpath("(//a[@class='myntraweb-sprite desktop-logo sprites-headerLogo ']//following::a[@data-index='0'])[1]"));
        category.click();
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("argument[0].scarguments[0].scrollIntoView(true);");
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        List<WebElement> link =    driver.findElements(By.tagName("link"));
        for(WebElement x:link) {
    	System.out.println(x);
    }

	}
	@Test
	public void method4() {
	WebElement search =	driver.findElement(By.xpath("//*[@class='desktop-searchBar']"));
		search.sendKeys("Tshirts");
		search.sendKeys(Keys.ENTER);
	}
	@Test
	public void method5() {
		String text ="HRX by Hrithik Roshan";
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
	WebElement wish =	driver.findElement(By.xpath("(//*[text()='HRX by Hrithik Roshan'])[2]"));
	Actions a = new Actions(driver);
	a.moveToElement(wish);
	a.click();
	}
	
}
