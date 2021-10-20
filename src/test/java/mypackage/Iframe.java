package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframe {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		
		driver.manage().window().maximize();
		
		//using xpath try but cannot inspect
		//driver.findElement(By.xpath("/html/body/main/ul/li[1]/a")).click();  //not work
		
		//so we need go into iframe
		
		//-----------1st frame---------------------

		driver.switchTo().frame("packageListFrame"); //use frame name // goto 1st frame then
		driver.findElement(By.xpath("//a[normalize-space()='org.openqa.selenium']")).click(); 
		//swith
		driver.switchTo().defaultContent(); //goto main page
		
		Thread.sleep(1000);
		
		//-----------2st frame---------------------
		driver.switchTo().frame("packageFrame"); //use frame name 
		driver.findElement(By.xpath("//a[normalize-space()='WebDriver']")).click(); 
		//swith
		driver.switchTo().defaultContent(); //goto main page
		
		Thread.sleep(1000);
		
		//-----------3st frame---------------------
		driver.switchTo().frame("classFrame"); //use frame name 
		driver.findElement(By.xpath("//div[@class='topNav']//a[normalize-space()='Help']")).click();
		
		// *********************1 frame work but 2nd not work because cannot go 1st to 2nd => switch
		
		
		
	}

}
