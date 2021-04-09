import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

public class Relativelocator {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://rahulshettyacademy.com/angularpractice/");
		
		// General Way to get a text from page
		//System.out.println(driver.findElement(By.xpath("//form[@class='ng-untouched ng-pristine ng-invalid']/div[1]/label")).getText());
		
		//By using friendly locators/Relative Locators
		
		//above
		//WebElement name=driver.findElement(By.xpath("//input[@name='name']"));
		//System.out.println(driver.findElement(withTagName("label").above(name)).getText());
		
		//below
		//WebElement dateofBirth=driver.findElement(By.xpath("//form[@class='ng-untouched ng-pristine ng-invalid']/div[7]/label"));
		//driver.findElement(withTagName("input").below(dateofBirth)).click();
		
		//WebElement name=driver.findElement(By.xpath("//form[@class='ng-untouched ng-pristine ng-invalid']/div[1]/label"));
		//driver.findElement(withTagName("input").below(name)).sendKeys("Uppala Redenkaiah");
		
		WebElement checkbox=driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(withTagName("input").toLeftOf(checkbox)).click();
		
		WebElement radio=driver.findElement(By.xpath("//label[text()='Employment Status: ']"));
		driver.findElement(withTagName("input").toRightOf(radio)).click();
		
		WebElement radioname=driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(withTagName("label").toRightOf(radioname)).getText());

	}

}
