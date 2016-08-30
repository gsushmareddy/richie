package mul_win;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



public class Spicejet_Popup {
	
	public WebDriver driver;
	
	
	@Test
	public void popup() throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");		
		driver=new ChromeDriver();
		driver.get("http://spicejet.com");
		
		
		//click one way search radio btn
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		//click on leaving from link
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		//click on HYD
		driver.findElement(By.linkText("Hyderabad (HYD)")).click();
		Thread.sleep(1000);
		//click on Banglore
		driver.findElement(By.linkText("Bengaluru (BLR)")).click();
		Thread.sleep(1000);
		//click on Date
		driver.findElement(By.linkText("20")).click();
		//select Adults
		new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")))
						.selectByVisibleText("2 Adults");
		//new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child"))).selectByVisibleText("1 Child");
		//new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant"))).selectByVisibleText("1 Infant");
		
		//click on find flights
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		Thread.sleep(3000);
		
		// POPUP operation
		
		
		String str;
		str=driver.getWindowHandle();
		
		//System.out.println("main window iD"+str);
		//click on currency convrter link
		driver.findElement(By.id("popUpConverter")).click();


		
	Set<String> str1=driver.getWindowHandles();
	System.out.println(str1);
	

	Object s[]=str1.toArray();
	
	driver.switchTo().window(s[1].toString());
	//click on Convert drop down
	new Select(driver.findElement(By.id("CurrencyConverterCurrencyConverterView_DropDownListBaseCurrency")))
				.selectByVisibleText("US Dollar(USD)");
	//click on into drop down
	new Select(driver.findElement(By.id("CurrencyConverterCurrencyConverterView_DropDownListConversionCurrency")))
					.selectByVisibleText("Indian Rupee(INR)");
	//enter amount
	driver.findElement(By.id("CurrencyConverterCurrencyConverterView_TextBoxAmount"))
					.sendKeys("200");
	//click on convert btn
	driver.findElement(By.id("CurrencyConverterCurrencyConverterView_ButtonConvert"))
					.click();
	Thread.sleep(3000);
	//click on Close btn
	driver.findElement(By.id("ButtonCloseWindow")).click();
	Thread.sleep(1000);
	
	//switch to popup to Main window
	driver.switchTo().window(s[0].toString());
	new Select(driver.findElement(By.id("AvailabilitySearchInputSelectViewdestinationStation1")))
					.selectByVisibleText("Ahmedabad (AMD)");
	}

}






