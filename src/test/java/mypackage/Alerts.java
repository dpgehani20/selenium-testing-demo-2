package mypackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//1. alert window with single ok button
		
		/*
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		*/
		
		//2. alert window with ok and cancel button
		
		/*
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		//=========== close alert using ok button =======================
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		//=========== close alert using cancel button =======================
		driver.switchTo().alert().dismiss();
		*/
		
		
		//3. alert window with input box, how to catch text from alert
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
		Thread.sleep(1000);
		
		Alert alertwindow =  driver.switchTo().alert();
		System.out.println("alert text = "+alertwindow.getText());
		
		alertwindow.sendKeys("Halo");
		alertwindow.accept();
		
		

	}

}
