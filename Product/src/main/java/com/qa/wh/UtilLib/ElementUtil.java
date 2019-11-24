package com.qa.wh.UtilLib;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementUtil {
	
WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver=driver;
	}
	
	/**
	 * Launching browser
	 * @param browsername
	 * @param url
	 * @return driver
	 */
	public WebDriver launchBrowser(String browsername, String url) {
			if(browsername.equals("chrome")) {
				ChromeOptions options= new ChromeOptions();
				options.addArguments("--disable-notifications");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
			}
				else if(browsername.equals("FireFox")) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();	
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(url);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	
		return driver;
		
	}
	/**
	 * This method user for locate element
	 * @param locator
	 * @return element
	 */

	public WebElement getElement(By locator) {
		WebElement element= null;
		waitforelementpresent(locator);
		try {
		element =driver.findElement(locator);
		}catch(Exception e) {
			System.out.println("Some exception occur while locating webelement"+locator);
		}
		return element;
	}
	/**
	 * This method is use for click on element
	 * @param locator
	 */
	public void doclick(By locator) {
		try {
		getElement(locator).click();
		}catch(Exception e) {
			System.out.println("Some exception occur while clicking webelement"+ locator);
		}
	}
	/**
	 * This method is use for enter value in textbox.
	 * @param locator
	 * @param value
	 */
	public void doSendKey(By locator, String value) {
		try {
		getElement(locator).clear();	
		getElement(locator).sendKeys(value);
		}catch(Exception e) {
			System.out.println("some exception occur while sendkey of element"+ locator);
		}
	}
	
	/**
	 * This is for wait for element present
	 * @param locator
	 */
	public void waitforelementpresent(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
	/**
	 * This method is use for select value from drop down.
	 * @param locator
	 * @param value
	 */
public void multiSelectDropDown(By locator, String...value) {
		
		List<WebElement> list =driver.findElements(locator);
		
		if(!value[0].equalsIgnoreCase("all")) {
			for(int i=0;i<list.size();i++) {
			String text = list.get(i).getText();
		
			for(int j=0;j<value.length;j++) {
			try{
			if(!text.isEmpty()) {
				if(text.equals(value[j])) {
				list.get(i).click();
				break;
				}
				}
			}
			catch(Exception e) {
					
				}
			}
			}
		}
		else {
			try{
				for(int k=0; k<list.size();k++) {
				list.get(k).click();
				}
			}
			catch(Exception e){
			}
		}
	}

		
	}



