package com.qa.wh.test;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.wh.BasePage.BasePage;
import com.qa.wh.PageLib.UserLoginPage;
import com.qa.wh.UtilLib.ElementUtil;

public class UserLoginTest {
	
	BasePage basepage;
	WebDriver driver;
	UserLoginPage login;
	Properties prop;
	

	
	@BeforeMethod
	public void setup(){
		basepage = new BasePage();
		prop =basepage.Intialize_property();
		driver = basepage.initializedriver(prop);
		login = new UserLoginPage(driver);
	}
	
		
	@Test
	public void loginTest() {
		login.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	

}	
	
