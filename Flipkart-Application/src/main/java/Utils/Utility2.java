package Utils;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility2 {
	
	public static void saveScreenshot (WebDriver driver, int testID) throws IOException
	{
	

	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	//String timestamp = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date(1));
	Date z=new Date();
	String b=z.toString().replace(":","_").replace(" "," _").replace("IST"," ");
	File dest=new File("F:\\Screenshot\\Test"+testID+""+b+".jpg");
	//File dest=new File("F:\\Screenshot\\"+"Test"+testID+timestamp+".jpg");

	FileHandler.copy(src, dest);	
	
}
}

//
//Date z=new Date();
//System.out.println(z);
//String b=z.toString().replace(":","_").replace(" "," _").replace("IST"," ");
//System.out.println(b);
//
//for(int i=0;i<=5;i++)
//{
//	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//
//	File dest=new File("F:\\Screenshot\\Test"+i+""+b+".jpg");
//
//	FileHandler.copy(src, dest);	
//	
//}
//}
//}