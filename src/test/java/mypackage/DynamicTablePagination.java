package mypackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTablePagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();
		
		//login
		WebElement username = driver.findElement(By.name("username"));
		username.clear();
		username.sendKeys("demo");
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys("demo");
		
		driver.findElement(By.xpath("//div[@class='text-right']//button")).click();
		
		//sales => order
		
		driver.findElement(By.xpath("//a[contains(text(),'Sales')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Orders')]")).click();
		
		//table
		
		// =========total no  of pages================
		String text = driver.findElement(By.xpath("//div[contains(text(),'Showing 1 to 20 of 10554 (528 Pages)')]")).getText();
		System.out.println(text);
		
		//to print only page no -> start index to final index
		int total_page_no =Integer.valueOf(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1));
		System.out.println("Pages: " +total_page_no);
		
		//no of raws
		// ***active page
		
		//for(int p=1;p<total_page_no;p++) //=====this take too much time so hardcode only for 3 pages
		for(int p=1; p<=1; p++) 	
		{
			WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
			System.out.println("Active page:" +active_page.getText());
			active_page.click();
			
			// *** raws
			int raws = driver.findElements(By.xpath("//*[@id=\"form-order\"]/table//tbody//tr")).size();
			System.out.println("No of raws: " +raws);
			
			
			// 3. read all data
			
			for(int r =1; r< raws; r++)
			{
				String orderId = driver.findElement(By.xpath("//*[@id=\"form-order\"]/table//tbody//tr["+r+"]//td[2]")).getText();
				String customer = driver.findElement(By.xpath("//*[@id=\"form-order\"]/table//tbody//tr["+r+"]//td[3]")).getText();
				//String status = driver.findElement(By.xpath("//*[@id=\"form-order\"]/table//tbody//tr["+r+"]//td[4]")).getText();
				
				//filter value (without if it print all)
				
				if(customer.equals("Anthon Frederik"))
				{
					System.out.println(orderId+ "   "+customer);
				}
				
			
			}
			
			//go to  next button
			
			String pageno = Integer.toString(p+1);
			driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+pageno+"']")).click();
		}
	}

}
