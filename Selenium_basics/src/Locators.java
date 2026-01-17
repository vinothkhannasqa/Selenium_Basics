
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators 
{
	WebDriver driver;

	public static void main(String[] args) 
	{
		Locators obj = new Locators();
		obj.launchbrowser();

	}
	public void launchbrowser()
	{
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		WebElement inputfield = driver.findElement(By.id("APjFqb"));
		inputfield.click();
		inputfield.sendKeys("Hello World");
		driver.quit();
	}

}
