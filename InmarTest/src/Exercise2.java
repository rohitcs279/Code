import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class Exercise2 {
	
	 public void SetDriver()
	  {
	  String basePath = new File("").getAbsolutePath();
	  System.out.println(basePath);
	  String path = new File("Driver/chromedriver.exe").getAbsolutePath();
	  System.setProperty("webdriver.chrome.driver", path);
	  } 

	 
  @Test(priority=1)
  
	 public static void FindAllLinks() {
	  
	  
	  WebDriver driver = new ChromeDriver();
	  
	  driver.get("http://www.inmar.com");
	  
	  java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
	  
	  System.out.println(links.size());
	  
	  for (int i = 0; i<=links.size()-1; i++)
	  
	  {
	  
	  System.out.println(links.get(i).getText());
	  
	  }
	  	
	  	driver.quit();
	  }
	
  
  @Test(priority=2)
  
	 public static void ImplicitWait() throws InterruptedException {
	  
	  WebDriver driver = new ChromeDriver();
	  
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.get("http://www.inmar.com");
	  WebElement myDynamicElement = driver.findElement(By.xpath("//a[text()='Contact']"));
	  myDynamicElement.click();
	  
	  driver.quit();
	  
  }
  @Test(priority=3)
  
	 public static void ExplicitWait() throws InterruptedException {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://www.inmar.com");
	  WebElement myElement = (new WebDriverWait(driver, 15))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Contact']")));
	  myElement.click();
	  
	  driver.quit();
	  
	  }
  
  @Test(priority=4)
  
	 public static void SeleniumExceptio()  {
	  
	 
	  WebDriver driver = new ChromeDriver();
	  
	 // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://www.inmar.com");
	  WebElement myDynamicElement = driver.findElement(By.xpath("//span[text()='More for retailers']"));
	 // myDynamicElement.click();
	  boolean blobj = myDynamicElement.isDisplayed();
	  //driver.quit();
	  if (blobj)
	  {
		  myDynamicElement.click();
	  }
	  
	  
		  throw new NoSuchElementException("No element exists");
	  }
	  
	}
	  
	 
	  
 
  
 
  
  
 
