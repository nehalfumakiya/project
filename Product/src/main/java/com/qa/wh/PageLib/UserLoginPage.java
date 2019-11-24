package com.qa.wh.PageLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.wh.BasePage.BasePage;
import com.qa.wh.UtilLib.ElementUtil;


public class UserLoginPage extends BasePage {
	
	ElementUtil elementutil;
	
	By email = By.id("admin_user_email");
	By password = By.id("admin_user_password");
	By loginbtn = By.name("commit");
	
	public UserLoginPage(WebDriver driver) {
		this.driver=driver;
		elementutil = new ElementUtil(driver);
	}
	
	public AddProductPage doLogin(String emailaddress, String newpassword) {
		elementutil.doSendKey(email, emailaddress);
		elementutil.doSendKey(password, newpassword);
		elementutil.doclick(loginbtn);
		return new AddProductPage(driver);
	}
}
