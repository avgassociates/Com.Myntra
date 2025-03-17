package TestNg;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Myntratest {
	
public	static WebDriver driver;
 
	
	@DataProvider(name = "Test")
	public Object[][] td() {
		return new  Object[][] {{"Myntra"}};
	}
	
	@DataProvider(name = "Test1")
	public Object[][] td1() {
		return new  Object[][] {{"T-shirts"}};
	}
	
	
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
	
	@Test(priority=0 , dataProvider ="Test")
	public void searchMyntra(String inputvalue) {
		driver.get("https://www.google.co.in/");
	WebElement search =	driver.findElement(By.xpath("//*[@class='gLFyf']"));
	driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	try {
	search.sendKeys(inputvalue + Keys.ENTER);	
	driver.findElement(By.xpath("//*[@class='x2VHCd OSrXXb ob9lvb']")).click();
	} catch(Exception e){
		e.printStackTrace();
	}
	}
	@Test(priority=1)
	public void men() {
		WebElement category = driver.findElement(By.xpath("(//a[@class='myntraweb-sprite desktop-logo sprites-headerLogo ']//following::a[@data-index='0'])[1]"));
        category.click();
////        JavascriptExecutor js = (JavascriptExecutor)driver;
////        js.executeScript("argument[0].scarguments[0].scrollIntoView(true);");
//        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
//        List<WebElement> link =    driver.findElements(By.tagName("link"));
//        for(WebElement x:link) {
//    	System.out.println(x);
//    }

	}
	@Test(priority=2, dataProvider = "Test1")
	public void searchTshirts(String input) {
	WebElement search =	driver.findElement(By.xpath("//*[@class='desktop-searchBar']"));
		search.sendKeys(input);
		search.sendKeys(Keys.ENTER);
	}
	@Test(priority=3)
	public void chooseProduct() {
		String text ="HRX by Hrithik Roshan";
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
	WebElement wish =	driver.findElement(By.xpath("//*[@title='COLOR CAPITAL Women V-Neck Extended Sleeves Pockets T-shirt']"));
	wish.click();
	}
	
	@Test(priority =4)
	public void add_to_bag() {
	String parent =	driver.getWindowHandle();
	Set<String> child = driver.getWindowHandles();
	for (String x : child) {
		if(!parent.equals(x)) {
			driver.switchTo().window(x);
			driver.findElement(By.xpath("//*[text()='M']")).click();
			driver.findElement(By.xpath("//span[@class='myntraweb-sprite pdp-whiteBag sprites-whiteBag pdp-flex pdp-center']")).click();
		}
		
	}
	}
	@AfterMethod
	public void aftermethod() {
		System.out.println("Executed After Method");

	}
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}