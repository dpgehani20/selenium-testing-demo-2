package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDragDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		/*
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		WebElement rome = driver.findElement(By.id("box6"));
		
		WebElement italy = driver.findElement(By.id("box106"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(rome, italy).perform();
		
		*/
		
		// drag and drop images
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"post-2669\"]/div[2]/div/div/div[1]/p/iframe")));
		
		WebElement item1 = driver.findElement(By.xpath("//li[1]"));
		WebElement item2 = driver.findElement(By.xpath("//li[2]"));
		
		WebElement trash = driver.findElement(By.id("trash"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(item1, trash).perform();
		act.dragAndDrop(item2, trash).perform();

	}

}
