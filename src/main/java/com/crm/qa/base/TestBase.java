package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	public TestBase(){
		//testUtil = new TestUtil();
		prop=new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("C:\\Users\\sawantm\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			
				prop.load(ip);
				
			
		}catch (FileNotFoundException e) {
				e.printStackTrace();
		}catch (IOException e) {
				e.printStackTrace();
		}
			
	}
	public static void intialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\sawantm\\eclipse-workspace\\FreeCRMTest\\resources\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\sawantm\\eclipse-workspace\\FreeCRMTest\\resources\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		if(prop.getProperty("browser").equals("firefox")) {
			driver.get(prop.getProperty("url")); //just for practice
		}
		else {
			driver.get(prop.getProperty("url"));
		}
		
	}

}
