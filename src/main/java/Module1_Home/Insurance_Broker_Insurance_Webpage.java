package Module1_Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Insurance_Broker_Insurance_Webpage
{
	//POM CLASS -2 
	
//1. Data members/Global Variables should be declared globally with access level private by using @findby Annotation

     @FindBy(xpath="//h4[text()='saradeg41@gmail.com']")     private  WebElement signedinas;
	
	 @FindBy(xpath="//input[@type='submit']")       private WebElement Logout;
	 
	
//2. Initialize within a constructor with access level public using pagefactory
	 
	public Insurance_Broker_Insurance_Webpage(WebDriver driver)
	    {
	    	PageFactory.initElements(driver, this);
	    	
	    }
//3. Utilize within a method with access level public	 
	
	public String GetEmail () 
	{
	    String	ActualEmail=signedinas.getText();
	    
	    return ActualEmail;
		
	}
	
	
	public void clickLogoutBtn() 
	{
		Logout.click();
	}


	
	
	
	
	
	
}
