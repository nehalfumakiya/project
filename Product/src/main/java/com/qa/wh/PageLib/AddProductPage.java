package com.qa.wh.PageLib;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.wh.BasePage.BasePage;
import com.qa.wh.UtilLib.ElementUtil;




public class AddProductPage extends BasePage{
	ElementUtil elementutil;
	
	By product = By.linkText("Products");
	By Addproduct = By.linkText("New Product");
	By title = By.id("product_title");
	By sku = By.id("product_sku");
	By description = By.id("product_description");
	By submit = By.name("commit");
	By edit = By.linkText("Edit Product");
	By delete = By.linkText("Delete Product");
	
	
	public AddProductPage(WebDriver driver) {
		this.driver=driver;
		elementutil = new ElementUtil(driver);
	}
	
	public void addnewproduct(String titlevalue, String skuvalue, String desctiptionvalue) {
		elementutil.doclick(product);
		elementutil.doclick(Addproduct);
		elementutil.doSendKey(title,titlevalue);
		elementutil.doSendKey(sku, skuvalue);
		elementutil.doSendKey(description, desctiptionvalue);
		elementutil.doclick(submit);
		}
	
	public void editproduct() {
		elementutil.doclick(edit);
		elementutil.doclick(submit);
	}
	
	public void deleteproduct() {
		elementutil.doclick(delete);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	
	}
	
}
