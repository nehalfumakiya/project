package com.qa.wh.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.wh.BasePage.BasePage;
import com.qa.wh.PageLib.AddProductPage;
import com.qa.wh.PageLib.UserLoginPage;


public class AddproductTest {
	
	BasePage basepage;
	Properties prop;
	AddProductPage addproduct;
	WebDriver driver;
	UserLoginPage login;
	
	
	@BeforeMethod
	public void setup(){
		basepage = new BasePage();
		prop = basepage.Intialize_property();
		driver = basepage.initializedriver(prop);
		login = new UserLoginPage(driver);
		addproduct = login.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test
	public void submitreviewtest() {
		addproduct.addnewproduct("Product11", "0012","This is a latest product1");		
	}
	
	@Test(priority=2)
	public void productedit() {
		addproduct.editproduct();
	}
	
	@Test()
	public void productdelete() {
		addproduct.deleteproduct();
	}
	
//	@Test(priority=3)
//	public void VerifySubmitReviewText() {
//		review.verifySubmitReview();
//		boolean actual = review.verifyReviewText();
//		Assert.assertEquals(actual, true);
//	}
//	
//	@AfterMethod
//	public void teardown() {
//		driver.quit();
//	}
}
