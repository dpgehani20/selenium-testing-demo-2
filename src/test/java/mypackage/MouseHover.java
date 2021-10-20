package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		
		WebElement desktop = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a"));
		WebElement menuitem = driver.findElement(By.xpath("//a[contains(text(),'Mac (1)')]"));
		
		Actions act = new Actions(driver);
		act.moveToElement(desktop).moveToElement(menuitem).click().perform();

	}

}
