package mypackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsAuth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		
		//Syntax
		//   https://username:password@the-internet.herokuapp.com/basic_auth
	    //then
		driver.get("admin:123@the-internet.herokuapp.com/basic_auth");

	}

}
