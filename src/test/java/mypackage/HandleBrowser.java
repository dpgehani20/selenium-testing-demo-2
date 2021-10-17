package mypackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		//getWindowHandle() return id for single web drowser
		
//		String windowId = driver.getWindowHandle();
//		System.out.println(windowId);
		// 1. output = CDwindow-7EC1B070D1237DE6A03F27D08286064D
		// 2. output may change everytime
		
		
		//getWindowHandles() // return id multiple web drowser
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click(); //open another window
		
		Set<String> windowIDs = driver.getWindowHandles();
		
		// 1. use iterator()
	/*	Iterator<String> it = windowIDs.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		System.out.println("parent id:" +parentId);
		System.out.println("child id:" +childId); */
		
		//2. or use list/ArrayList
		List<String> windowIdList = new ArrayList(windowIDs); //convert set to list
		
		String parentWId = windowIdList.get(0);
		String childWId = windowIdList.get(1);
		
	/*	System.out.println("parent id:" +parentWId);
		System.out.println("child id:" +childWId);
		
		//how to use window ids for switching
		driver.switchTo().window(parentWId);
		System.out.println("parent window title: "+ driver.getTitle());
		
		driver.switchTo().window(childWId);
		System.out.println("parent window title: "+ driver.getTitle());
	*/
		
		//for each loop
		for(String winId :windowIdList) 
		{
//			System.out.println(winId);
			String title = driver.switchTo().window(winId).getTitle();
			System.out.println(title);
		}
		
		driver.close(); //point child browser it closed ->single browser closed
		driver.quit(); // close all
		
		// close browser according to my choice
		for(String winId :windowIdList) 
		{
			String title = driver.switchTo().window(winId).getTitle();
			if(title.equals("OrangeHRM") || title.equals("other title")) {
				driver.close();
			}
		}

	}

}
