package TestNg;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Myntratest {
	
	static WebDriver driver;
	@BeforeClass
	public void launchBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("Start-maximized");
		options.addArguments("disable-popups");
		 driver = new ChromeDriver(options);
		 System.out.println("Executed before class");
		 
		 	}
	@BeforeMethod
	public void beforemethod() {
		
	//String title =	driver.getTitle();
		System.out.println("Before Method");
	}
	
	@Test(priority=0)
	public void searchMyntra() {
		driver.get("https://www.google.co.in/");
	WebElement search =	driver.findElement(By.xpath("//*[@class='gLFyf']"));
	driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	try {
	search.sendKeys("Myntra" + Keys.ENTER);	
	driver.findElement(By.xpath("//*[@class='x2VHCd OSrXXb ob9lvb']")).click();
	} catch(Exception e){
		e.printStackTrace();
	}
	}
	@Test(priority=1)
	public void men() {
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
	@Test(priority=2)
	public void searchTshirts() {
	WebElement search =	driver.findElement(By.xpath("//*[@class='desktop-searchBar']"));
		search.sendKeys("Tshirts");
		search.sendKeys(Keys.ENTER);
	}
	@Test(priority=3)
	public void chooseProduct() {
		String text ="HRX by Hrithik Roshan";
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
	WebElement wish =	driver.findElement(By.xpath("(//*[text()='HRX by Hrithik Roshan'])[2]"));
	Actions a = new Actions(driver);
	a.moveToElement(wish);
	a.click();
	}
	@AfterMethod
	public void aftermethod() {
		System.out.println("Executed After Method");

	}
	@AfterClass
	public void afterClass() {
		System.out.println("Executed After Method");
	
	}
}
