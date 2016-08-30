package mul_win;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.Test;

public class Datepicker12 {
  private WebElement table;

@Test
  public void f() {
	  
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe" );
			WebDriver driver=new ChromeDriver();	
			
			//FirefoxDriver driver=new FirefoxDriver();
			driver.get("http://www.cleartrip.com/");
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			
			driver.findElement(By.id("OneWay")).click();
			driver.findElement(By.id("FromTag")).sendKeys("Hyderabad, IN - Rajiv Gandhi International (HYD)");
			driver.findElement(By.id("ToTag")).sendKeys("Bhubaneswar, IN - Biju Patnaik (BBI)");
			//click date 
			driver.findElement(By.xpath("//*[@id='ORtrip']/section[2]/div[1]/dl/dd/div/a/i")).click();
			                            
			//user defined date
			String doj="10/05/2017";
			
			
			String[] a=doj.split("/");
			String[] months={"January","February","March","April","May","June","July","August","September","October","November","December"};
			
			
			int x=Integer.parseInt(a[1]);
			String month=months[x-1];
			
			String day=a[0];
			String year=a[2];
			
			
			//identify the year in the calf
			String calyear=driver.findElement(By.className("ui-datepicker-year")).getText();
			
			while(!calyear.equals(year))
			{
				//click arrow in calf
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a")).click();
				calyear=driver.findElement(By.className("ui-datepicker-year")).getText();
			}
			// identify the month in the calf
			String calmonth=driver.findElement(By.className("ui-datepicker-month")).getText();
			while(!calmonth.equals(month))
			{
				//click arrow in calf
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a")).click();
				calmonth=driver.findElement(By.className("ui-datepicker-month")).getText();
			}
			
			
 
			table=driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]"));
			java.util.List<WebElement> rows=table.findElements(By.tagName("tr"));
			
			System.out.println(rows.size());
			// loop for rows
			for(int i=0;i<rows.size();i++)
			{
				//from row get no.of columns
				java.util.List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
				// loop for columns in rows(i) 
				for(int j=0;j<cols.size();j++)
				{
					if(cols.get(j).getText().equals(day))
					{
						// click matching date
						cols.get(j).click();
						break;
					}
				}
			}
			Sleeper.sleepTightInSeconds(4);
			//click find flights
			driver.findElement(By.id("SearchBtn")).click();
			
		}
		
	}


