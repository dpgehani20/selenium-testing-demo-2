package mypackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromiumdriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.monsterindia.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[contains(text(),'Upload Resume')]")).click();
		
		/*
		// input type = file -> directly set sendkeys
		driver.findElement(By.xpath("//body/div[@id='themeDefault']/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/section[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("F:\\A-officce\\sample report\\sample.txt");
		*/
		
		// using robot class method
		WebElement button = driver.findElement(By.xpath("//body/div[@id='themeDefault']/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/section[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", button); //click on button
		
		/*
		 actions in robot class====================
		 1. copy  the path
		 2. ctrl + v
		 3. press enter
		 */

		Robot rt = new Robot();
		rt.delay(2000);
		
		//put path to file in a clipboard
		
		StringSelection ss = new StringSelection("F:\\A-officce\\sample report\\sample.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		//ctrl+v
		rt.keyPress(KeyEvent.VK_CONTROL); //press on Ctrl
		rt.keyPress(KeyEvent.VK_V);  //press on V
		
		rt.keyRelease(KeyEvent.VK_CONTROL);
		rt.keyRelease(KeyEvent.VK_V);
		
		rt.delay(2000);
		
		//enter key
		
		rt.keyPress(KeyEvent.VK_ENTER);
		rt.keyRelease(KeyEvent.VK_ENTER);
	}

}
