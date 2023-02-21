package Library_files;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass
{
	  public WebDriver driver;    //globaly declared object
	
	public void InitializeBrowser() 
	{
		//Step 1
	System.setProperty("Webdriver.chrome.driver", "C:\\Users\\shri\\eclipse-workspace\\1_oct_Maven\\Browser\\chromedriver.exe");
				
	    //step 2
      driver=new ChromeDriver();
				
	    //To enter URL
	 driver.get("https://demo.guru99.com/insurance/v1/index.php");
		
	 //To maximize window
	 driver.manage().window().maximize();
	 
	 //Wait
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	 
		
	}


}
