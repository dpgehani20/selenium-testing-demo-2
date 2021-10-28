package mypackage;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		RemoteWebDriver driver = new ChromeDriver();
		
		driver.get("https://www.snapdeal.com/");
		
		driver.navigate().to("https://www.amazon.com/");
		
		// ---------get and navigate to do same job
		// driver.get("https://www.amazon.com/");
		
		driver.navigate().back();  //snapdeal
		driver.navigate().forward();  //amazon
		
		driver.navigate().refresh();
		
		
		/*
		 @Override
  public void get(String url) {
    execute(DriverCommand.GET(url));
  }
		 */
		

	}

}
