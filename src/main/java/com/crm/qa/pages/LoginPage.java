package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//PageFactory
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"loginForm\"]/div/div/input")
	WebElement btnLogin;
	
	@FindBy(xpath="//*[text()='Sign Up']")
	WebElement btnSignUp;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	//Initializing page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);		
	}
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean validateCRMLogo(){
		return crmLogo.isDisplayed();
	}
	public HomePage Login(String user,String pwd) {
		username.sendKeys(user);
		password.sendKeys(pwd);
		btnLogin.click();
		return new HomePage();
	}

}
