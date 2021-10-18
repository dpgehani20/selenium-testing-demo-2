package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Today's Deals")).click();  //Or
		driver.findElement(By.partialLinkText("Deals")).click();
		
		//capture all links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("all links : "+links.size());
		
		//normal for loop
		for(int i=0;i<links.size(); i++)
		{
			System.out.println(links.get(i).getText());
			System.out.println(links.get(i).getAttribute("href"));
		}
		
		// or
		for(WebElement link:links)
		{
			System.out.println(link.getText());
			System.out.println(link.getAttribute("href"));
		}

	}

}
