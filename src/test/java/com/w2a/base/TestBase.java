package com.w2a.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class TestBase {

	/*     TestBase class is the base of our framework we use it to initialize the things that are required in the framework
	       and every test class will extend this class.

	 * WebDriver - done
	 * Properties - done
	 * Logs - done
	 * ExtentReports
	 * Mail
	 * DB
	 * Excel

	 */

	public static WebDriver driver;

	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	
	public Logger log = Logger.getLogger(TestBase.class);

	@BeforeSuite
	public void setUP() throws IOException {
		
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\log4j.properties");

		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);
		log.debug("config file loaded");

		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);
		log.debug("OR file loaded");

			if(driver == null) 
			{
	
					if(config.getProperty("browser").equals("firefox")) 
					{
						System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
						driver = new FirefoxDriver();
						log.info("Launching Firefox driver");
					}
					if(config.getProperty("browser").equals("chrome")) 
					{
						System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
						driver = new ChromeDriver();
						log.info("Launching Chrome driver");
					}
					if(config.getProperty("browser").equals("edge")) 
					{
						System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\msedgedriver.exe");
						driver = new EdgeDriver();
						log.info("Launching Edge driver");
					}
					
			driver.get(config.getProperty("testSiteUrl"));
			log.info("Opened Test Site Url");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);

			}

	}

	@AfterSuite
	public void tearDown() {

		if(driver!=null) {
			
			driver.quit();
		}
		
	}

}
