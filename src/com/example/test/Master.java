package com.example.test;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import Utilities.CaptureScreenShotOnFailure;

public class Master 
{
	public static WebDriver driver=null;
	public static Properties config=null;
	public static Properties or=null;
	@BeforeMethod
	public static void Master() throws IOException
	{
		if(driver==null)
		{		
			//load configuration properties
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\Utilities\\config.properties");	
			config= new Properties();
			config.load(ip);
	
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\Utilities\\chromedriver.exe");
			driver=new ChromeDriver();	
			driver.get("http://www.williams-sonoma.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
	
	}
	
	@AfterMethod
	public static void TestResult(ITestResult result) throws IOException, AWTException 
	{
		if(ITestResult.FAILURE==result.FAILURE)
		{
			CaptureScreenShotOnFailure.captureScreenShot(result.getName(), driver);
		}
		driver.close();
	}
	public static void click(String xpathKey)
	{
		System.out.println(xpathKey);
		driver.findElement(By.xpath(config.getProperty(xpathKey))).click();
	}
}