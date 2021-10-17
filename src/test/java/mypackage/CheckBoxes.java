package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		
		//1. select specific checkbox -> located one element******************
		
		driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
		//2. select all check boxes -> locate all checkboxes -> point out which are contain 'day'****
		
		List<WebElement> daylist = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		
		System.out.print("total checkbox num: "+daylist.size());
		
		   // A) using for loop ..index =7
		for(int i=0; i<daylist.size(); i++) {
			daylist.get(i).click();
		}
		 
		  //B) using each for loop
		for(WebElement checkbox: daylist) {
			checkbox.click();
		}
		
		//3. select multiple checkboxes based on choice*********************
		// I want to select monday, sunday
		
		for(WebElement checkbox: daylist)
		{
			String mychoice = checkbox.getAttribute("id");
			if(mychoice.equals("monday") || mychoice.equals("sunday")) 
			{
				checkbox.click();
			}
		}
		
		//4. select last 2 checkboxes (0,1,2,3,4,5,6)
		// count total no(7) -> how many checkboxes need to select from last(2) -> 1.7-2=i5 / 7-1=i6

		int totalcheckboxes = daylist.size();
		
		for(int i=totalcheckboxes-2; i<totalcheckboxes; i++)
		{
			daylist.get(i).click();
		}
		
		
		//5. select first 2 checkboxes
		for(int i=0; i<totalcheckboxes; i++)
		{
			if(i<2)
			{
				daylist.get(i).click();
			}
		}
	}

}
