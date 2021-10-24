package mypackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();

		
		String year="2021";
		String month="Dec";
		String day ="25";
		
		driver.findElement(By.xpath("//*[@id=\"onward_cal\"]")).click();  //open date picker
		
		//select yr ,month
		while(true)
		{
			String monthyr = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			
			String arr[] = monthyr.split(" ");
			String mnth = arr[0];
			String yr = arr[1];
			
			if(mnth.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year))
			  break;
			
			else
				driver.findElement(By.xpath("//td[@class='next']//button")).click();
		}
		
		//select date
		
		List<WebElement> alldates = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));
		
		for(WebElement ele: alldates)
		{
			String dt = ele.getText();
			if(dt.equals(day)) 
			{
				ele.click();
				break;
			}
		}
		
		
	}

}
