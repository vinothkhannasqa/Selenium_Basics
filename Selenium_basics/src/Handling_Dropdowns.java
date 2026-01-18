import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Handling_Dropdowns
{
	WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		Handling_Dropdowns obj = new Handling_Dropdowns();
		obj.launch_browser();

	}
	public void launch_browser() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com");
		driver.manage().window().maximize();
		select_option();
	}
	public void select_option() throws InterruptedException
	{
		WebElement dd1 = driver.findElement(By.id("drop1"));
		dd1.click();
		
		Select s1 = new Select(dd1);
		
		Boolean dd_type =s1.isMultiple();
		
		String result = dd_type?"yes":"no";
		System.out.println(result);
		
		List<WebElement> options = s1.getOptions();
		for(WebElement opt : options)
		{
			String option = opt.getText();
			System.out.println(option);
		}
		
		String default_option = s1.getFirstSelectedOption().getText();
		System.out.println("Default selected option is - "+default_option);
		
		s1.selectByIndex(1);
		Thread.sleep(1500);
		s1.selectByValue("ghi");
		Thread.sleep(1500);
		s1.selectByVisibleText("doc 3");
		Thread.sleep(1500);
		/*s1.deselectAll();                  //de-select option will work only for multi-select dropdowns
		Thread.sleep(1500);*/
		
		String final_option = s1.getFirstSelectedOption().getText();
		System.out.println("After all play - "+final_option);
		driver.quit();
		
	}

}
