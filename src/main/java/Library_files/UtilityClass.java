package Library_files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class UtilityClass 
{
	 //Automation TE:@Nikita
		//Date:15/02/2023
		//Day:Wed
		//Title: Fetch data from property file
		
		@Test
		public static String getdatafromPF(String Key) throws IOException
		{
		   //to reach upto property file
		   FileInputStream  File=new  FileInputStream ("C:\\Users\\shri\\eclipse-workspace\\1_oct_Maven\\Propfile.properties");
		
		   //Create object of properties class
		   Properties  prop=new  Properties();
		   
		   //To open Property file
		   prop.load(File);
		   
		   //To fetch data from Property File 
		  String  Value = prop.getProperty(Key);
		
		        return Value;  
		
		}
		
		//Automation TE:@Nikita
		//Date:15/02/2023
		//Day:Wed
		//Title: Fetch data from Excel Sheet
		
		@Test
		public static String getdatafromexcelsheet(int RowIndex,int Cellindex) throws EncryptedDocumentException, IOException 
		{
			//To Reach Upto Excelsheet
			FileInputStream File=new  FileInputStream("C:\\Users\\shri\\eclipse-workspace\\1_oct_Maven\\Test_Data\\Book2.xlsx");
			
			//To Open Excel sheet
		    Sheet  sh=WorkbookFactory.create(File).getSheet("Sheet1");
			
		    
	     	String  Value2=sh.getRow(RowIndex).getCell(Cellindex).getStringCellValue();
			
		    return Value2;
		
		}
		
		
		@Test
		public static void CaptureScreenShot(WebDriver driver, int TestCaseID) throws IOException 
		{
			  File  Source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  
			  File Destination=new File("C:\\Users\\shri\\eclipse-workspace\\1_oct_Maven\\Screenshot\\"+TestCaseID+".jpg");
			  
			  FileHandler.copy(Source,Destination);
		
		
		
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

}











