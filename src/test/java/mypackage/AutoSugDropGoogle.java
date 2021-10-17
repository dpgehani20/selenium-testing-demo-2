package mypackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSugDropGoogle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("javascript");
		Thread.sleep(1000);
		List<WebElement> list =  driver.findElements(By.xpath("//li[@class='sbct']//div[@role='option']//div[1]/span"));
		
		System.out.println("auto suggetion list num :"+list.size());
		
		for(WebElement listitem:list) {
			if(listitem.getText().contains("map")) {
				listitem.click();
				break;
			}
		}
		

	}

}
