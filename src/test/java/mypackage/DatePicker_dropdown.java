package mypackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker_dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='appoinmentdate']")).click();
		
		Select month = new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[1]")));
		month.selectByVisibleText("Dec");
		
		
		Select yr = new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[2]")));
		yr.selectByVisibleText("2013");
		
		String date ="2";
		
		List<WebElement> alldates = driver.findElements(By.xpath("//body/div[@id='ui-datepicker-div']/table[1]//td"));
		
		for(WebElement ele : alldates)
		{
			String dt = ele.getText();
			
			if(dt.equals(date))
			{
				ele.click();
				break;
			}
		}
		
		

	}

}
