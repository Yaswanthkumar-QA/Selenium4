import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Invoking_windows {

	public static void main(String[] args) throws InterruptedException, IOException {
		
				
		//Invoking Multiple Windows/Tabs from Selenium by using one driver instance
		/*
		 				Scenario
		 		//// New Features/Scenarios introduces in Selenium 4.0
		 	1. Navigate to: http://rahulshettyacademy.com/angularpractice/
		 	2.Fill the Name field with the first course name available in http://rahulshettyacademy.com
		 */
		
		System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://rahulshettyacademy.com/angularpractice/");
		
		//driver.switchTo().newWindow(WindowType.TAB);		// New tab will open
		driver.switchTo().newWindow(WindowType.WINDOW);		// New window will open
		
		Set<String>windows=driver.getWindowHandles();
		Iterator<String> it= windows.iterator();
		String parentId=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);
		driver.get("http://rahulshettyacademy.com");
		
		//String courseName=driver.findElements(By.xpath("//div[@class='upper-box']/h2[1]")).get(1).getText();
		
		//driver.switchTo().window(parentId);
		
		//driver.findElement(By.xpath("//div[@class='form-group'] //input[@name='name']")).sendKeys(courseName);
		
		//Thread.sleep(3000);
		
		//driver.quit();
		
		
		/*
		 
		 					// New Features/Scenarios introduces in Selenium 4.0
		// Capture WebElement Screen Using Selenium ie., Partial Screen
		// Get Height Width of WebElement using Selenium
		 
		*/
		// Capture WebElement Screen Using Selenium ie., Partial Screen
		String courseName=driver.findElements(By.xpath("//div[@class='upper-box']/h2[1]")).get(1).getText();
		
		driver.switchTo().window(parentId);
		
		WebElement name=driver.findElement(By.xpath("//div[@class='form-group'] //input[@name='name']"));
		name.sendKeys(courseName);
		
		//Thread.sleep(3000);
		
		File filename=name.getScreenshotAs(OutputType.FILE);
		
		
		FileUtils.copyFile(filename, new File("D:\\Testing\\Selenium\\filelogo.png"));
		
		// Get Height Width of WebElement using Selenium
		
		System.out.println("Height "+ name.getRect().getDimension().getHeight());
		System.out.println("Width "+ name.getRect().getDimension().getWidth());

	}

}
