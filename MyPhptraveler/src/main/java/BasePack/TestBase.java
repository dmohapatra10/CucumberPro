package BasePack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	WebDriver driver;
	FileInputStream fis;
	Properties prop;
	
	TestBase() throws IOException
	{
		
		prop=new Properties();
		fis=new FileInputStream("C:\\Users\\dmoha\\eclipse-workspace\\MyPhptraveler\\src\\main\\java\\Config\\config.properties");
		prop.load(fis);
	}
	
	
	public void init(String browserName) {
		
		
		browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\dmoha\\eclipse-workspace\\MyPhptraveler\\Drivers\\geckodriver-v0.23.0-win32\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\dmoha\\eclipse-workspace\\MyPhptraveler\\Drivers\\chromedriver_win32 (2)\\chromedriver.exe");

		}
		
	}

}
