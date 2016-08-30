package mul_win;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ROBOT_SAVE {
  @Test
  public void f() throws AWTException {
	  FirefoxDriver d=new FirefoxDriver();
	 d.get("http://www.seleniumhq.org/download/");
	 d.manage().window().maximize();
	 d.findElement(By.xpath(".//*[@id='mainContent']/p[3]/a")).click();
	 Robot nky=new Robot();
	 nky.keyPress(KeyEvent.VK_LEFT);
	 
	 nky.keyRelease(KeyEvent.VK_TAB);
	 nky.delay(2000);
	 nky.keyPress(KeyEvent.VK_ENTER);
	 nky.keyRelease(KeyEvent.VK_ENTER);
	  
  }
}
