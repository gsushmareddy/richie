package mul_win;

//import java.awt.Window;
import java.sql.Driver;
import java.util.Iterator;
import java.util.Set;

import org.apache.http.cookie.SetCookie;
//import org.apache.jasper.tagplugins.jstl.core.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.Test;

//import com.sun.jna.platform.win32.WinUser.WINDOWINFO;

public class windhandle {
  @Test
  public void multiplewindowtest() {
	  FirefoxDriver Driver = new FirefoxDriver();
	  Driver.get("http://www.icicibank.com/");
	  Driver.manage().window().maximize();
	  Sleeper.sleepTightInSeconds(2);
	  Driver.findElement(By.linkText("Private")).click();
	  
	Set<String> s=Driver.getWindowHandles();	
	Iterator<String> itr=s.iterator();
	while (itr.hasNext()){
		Driver.switchTo().window(itr.next());
		try {
			Driver.findElement(By.id("Search")).sendKeys("loans");
			break;
		} catch (Exception e) {
			System.out.println("no=======");
		}
		
		
	}
	  
	  
  }
}
