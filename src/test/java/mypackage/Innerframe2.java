package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Innerframe2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width_css");
		
		driver.switchTo().frame("iframeResult");  //switch to outer iframe
		
		driver.switchTo().frame(0); //switch to inner iframe
		
		System.out.println("inner text : "+driver.findElement(By.xpath("//h1")).getText());
		
		driver.switchTo().parentFrame();  //goto parent or outer frame
		
		String text = driver.findElement(By.xpath("//p[contains(text(),'You can also use the CSS height and width')]")).getText();
		
		System.out.println(text);

	}

}
