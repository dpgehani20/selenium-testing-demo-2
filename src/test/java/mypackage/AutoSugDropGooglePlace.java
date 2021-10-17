package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSugDropGooglePlace {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		WebElement searchbox =  driver.findElement(By.id("autocomplete"));
		
		searchbox.clear();
		
		searchbox.sendKeys("colombo");
		
		String text;
		
		do 
		{
			
			searchbox.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
			text = searchbox.getAttribute("value");
			
			if(text.equals("Colombo Fort Station, Colombo, Sri Lanka")) {
				searchbox.sendKeys(Keys.ENTER);
				break;
			}
			Thread.sleep(1000);
		}while(! text.isEmpty());

	}

}
