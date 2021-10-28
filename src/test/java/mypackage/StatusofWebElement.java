package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusofWebElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com/register");

		//isDisplay() isEnable()   -> any element

		WebElement searchstore =  driver.findElement(By.xpath("//input[@id='small-searchterms']"));

		// true or false

		System.out.println("Display Status of element: "+searchstore.isDisplayed());

		System.out.println("Enable Status of element: "+searchstore.isEnabled());

		//isSelected()   -> Radio button, checkboxes, dropdown

		WebElement femalebutton =  driver.findElement(By.xpath("//input[@id='gender-female']"));
		WebElement malebutton =  driver.findElement(By.xpath("//input[@id='gender-male']"));

		System.out.println("Before Status of element: "+femalebutton.isSelected());  //false
		System.out.println("Before Status of element: "+malebutton.isSelected());  //false

		//select female button
		femalebutton.click();

		System.out.println("After Status of element: "+femalebutton.isSelected());  //true
		System.out.println("After Status of element: "+malebutton.isSelected());  //false

		//select male button
		malebutton.click();

		System.out.println("After second Status of element: "+femalebutton.isSelected());  //false
		System.out.println("After second Status of element: "+malebutton.isSelected());  //true

	}

}
