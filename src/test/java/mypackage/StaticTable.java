package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 1. how many raws/columns
 2. retrieve data from specific raw and column
 3.retrieve all table data
 4.print Release date,VersionNo of java
 */

public class StaticTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		driver.manage().window().maximize();
		
		
		// 1. how many raws
		
		int raws = driver.findElements(By.xpath("//table[@class='tsc_table_s13']//tbody//tr")).size();
		System.out.println("Raws total :"+raws);
		
		// 1. how many columns
		
		int columns = driver.findElements(By.xpath("//table[@class='tsc_table_s13']//thead//th")).size();
		System.out.println("Raws total :"+columns);
		
		/*
		 
		// 2. retrieve data from specific raw and column
		
		String value = driver.findElement(By.xpath("//table[@class='tsc_table_s13']//tbody//tr[1]//td[1]")).getText(); //UAE
		System.out.println("the value :"+value);
		
		// 3. all 
		System.out.println("All data....");
		
		for(int r=1;r<raws;r++) 
		{
			for(int c=1;c<columns;c++)
			{
				String all = driver.findElement(By.xpath("//table[@class='tsc_table_s13']//tbody//tr["+r+"]//td["+c+"]")).getText(); //UAE
				System.out.println(all +"   ");
			}
			System.out.println();
		}
		
		*/
		
		//5.**not work for me
		
		for(int i=1;i<raws;i++)
		{
			String structure = driver.findElement(By.xpath("//table[@class='tsc_table_s13']//tbody//tr["+i+"]//th")).getText();
			
			if(structure.equals("Financial Center"))
			{
				String city= driver.findElement(By.xpath("//table[@class='tsc_table_s13']//tbody//tr["+i+"]//td[2]")).getText();  //Shanghai
				String built= driver.findElement(By.xpath("//table[@class='tsc_table_s13']//tbody//tr["+i+"]//td[4]")).getText();  //2008
			
				System.out.println("city : " +city+ "   built:  "+built);
			}
		}
		
		
		driver.quit();
		
		
		
	}

}
