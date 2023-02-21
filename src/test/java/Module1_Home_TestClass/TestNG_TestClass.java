package Module1_Home_TestClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library_files.BaseClass;
import Library_files.UtilityClass;
import Module1_Home.Insurance_Broker_Insurance_Webpage;
import Module1_Home.Insurance_Login;

public class TestNG_TestClass extends BaseClass
   {
	//InitializeBrowser(); 
	//public WebDriver driver;
	
	Insurance_Login  L1; 
	Insurance_Broker_Insurance_Webpage  L2;
	int TestCaseID;
	
	@ BeforeClass 
	public void OpenBrowser() 
	{
		InitializeBrowser(); 
		
	   //Create object of POM Class -1
	     L1=new  Insurance_Login(driver);

	  //Create object of POM Class -2
	     L2=new Insurance_Broker_Insurance_Webpage(driver);
	   
	}
	
	@ BeforeMethod
	public void LoginToApp() throws IOException 
	{
		 L1.EnterEmail(UtilityClass.getdatafromPF("EM"));
		 
		 L1.EnterPassword(UtilityClass.getdatafromPF("PSW"));
		
		 L1.Clickloginbtn();
	}
	
	
	@ Test(priority=1)
	public void VerifyEmailAdress() throws EncryptedDocumentException, IOException 
	{
		  String  ActualEmail=L2.GetEmail();
		
		String ExpectedEmail=UtilityClass.getdatafromexcelsheet(2, 0);
		
		Assert.assertEquals(ActualEmail, ExpectedEmail);
	}
	
	
	@ Test(priority=2)
	public void VerifyTitle() throws EncryptedDocumentException, IOException 
	{
		TestCaseID=102;
		
		String ActualTitle= driver.getTitle();
		
		String ExpectedTitle=UtilityClass.getdatafromexcelsheet(3, 0);
		
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		
	}
	
	
	@ AfterMethod
	public void LogedOutfromApp(ITestResult Result) throws IOException 
	{
		if(Result.getStatus()==ITestResult.FAILURE)
		
			UtilityClass.CaptureScreenShot(driver, TestCaseID);
		
		L2.clickLogoutBtn();
	}
	
	@ AfterClass
	public void Closebrowser() 
	{
		
		driver.close();
	}
	
	
	
	
	
	

}
