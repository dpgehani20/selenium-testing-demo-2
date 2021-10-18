package mypackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrokenLinks {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.deadlinkcity.com/");
		
		List<WebElement> links= driver.findElements(By.tagName("a"));
		
		int linkcount =0;
		
		for(WebElement element:links)
		{
			String url =  element.getAttribute("href");
			
			if(url==null || url.isEmpty()) 
			{
				System.out.println("url empty");
				continue;
			}
			
			URL link = new URL(url);
			try 
			{
				HttpURLConnection httpconn = (HttpURLConnection)link.openConnection();
				httpconn.connect();
				
				if(httpconn.getResponseCode()>=400)
				{
					System.out.println(httpconn.getResponseCode()+url +" is broken link");
					linkcount ++;
				}
				else
				{
					System.out.println(httpconn.getResponseCode()+url +" is not broken link");
				}
				
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				
			}
		}
		
		System.out.println("no of broken links : "+linkcount);

	}

}
