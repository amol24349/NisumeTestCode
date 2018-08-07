package com.example.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NisumTest extends Master
{
	@Test
	public void SonomaTest() 
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		if(driver.findElements( By.xpath(config.getProperty("popUpCloseButton"))).size() != 0)
		{
			click("popUpCloseButton");
			System.out.println("pop-up is closed");
		}
		else 
			System.out.println("No pop-up found");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Actions act = new Actions(driver);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("cookwareLink"))));
		driver.findElement(By.xpath(config.getProperty("cookwareLink"))).click();;
		
		if(driver.findElements( By.xpath(config.getProperty("popUpCloseButton"))).size() != 0)
		{
			click("popUpCloseButton");
			System.out.println("pop-up is closed");
		}
		else 
			System.out.println("No pop-up found");
		
		jse.executeScript("window.scrollBy(0,250)", "");
		if(driver.findElements( By.xpath(config.getProperty("popUpCloseButton"))).size() != 0)
		{
			click("popUpCloseButton");
			System.out.println("pop-up is closed");
		}
		else 
			System.out.println("No pop-up found");
		
		System.out.println("Clicking on Tea Kettles");
		click("TeaKettles");
		System.out.println("Selecting Capresso H20 Electric Glass Kettle");
		jse.executeScript("window.scrollBy(0,850)", "");
		
		String selectedProduct = driver.findElement(By.xpath(config.getProperty("selectedProduct"))).getText();
		click("selectedProduct");
		System.out.println("Product got selected : "+selectedProduct);
		
		System.out.println("Clicking button - Add TO CART");
		jse.executeScript("window.scrollBy(0,550)", "");
		click("addToCart");
		
		System.out.println("Clicking on Check-out Button");
		click("checkOutButton");
		
		System.out.println("Clicking Save to Later Button");
		jse.executeScript("window.scrollBy(0,550)", "");
		click("saveToLater");
		
		System.out.println("Clicking on 1 saved item Link");
		click("saved1itemLink");
		
		System.out.println("Verifying 1 saved item");
		String savedItem = driver.findElement(By.xpath(config.getProperty("savedItem"))).getText();
		
		if(selectedProduct.equals(savedItem))
		System.out.println("Selected product item is matching with saved item");
		else
		System.out.println("Selected product item & Saved item is not matching");	
	}
}
