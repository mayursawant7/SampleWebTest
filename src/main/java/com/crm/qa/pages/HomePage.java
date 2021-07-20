
  package com.crm.qa.pages;
  
  import org.openqa.selenium.WebElement; import
  org.openqa.selenium.interactions.Actions; import
  org.openqa.selenium.support.FindBy; import
  org.openqa.selenium.support.PageFactory;
  
  import com.crm.qa.base.TestBase;
  
  public class HomePage extends TestBase{
  
  @FindBy(xpath="//*[contains(text(),'User: group automation')]") WebElement
  userNameLabel;
  
  @FindBy(xpath="//a[contains(text(),'Contacts')]") WebElement contactsLink;
  
  @FindBy(xpath="//a[contains(text(),'New Contact')]") WebElement newContact;
  
  @FindBy(xpath="//a[contains(text(),'Deals')]") WebElement dealsLink;
  
  @FindBy(xpath="//a[contains(text(),'Tasks')]") WebElement tasksLink; 
  public  HomePage() { 
	  PageFactory.initElements(driver, this);
	  } 
  public boolean  verifyUserName() { return userNameLabel.isDisplayed(); } 
  public String verifyHomepageTitle() { return driver.getTitle(); } 
  public ContactsPage clickContacts() { 
	  contactsLink.click(); 
  return new ContactsPage(); } 
  public DealsPage clickDeals() { dealsLink.click(); return new DealsPage(); } 
  public TasksPage clickTasks() { tasksLink.click(); return new TasksPage(); }
  
  public void clickOnNewContact() {
  
  Actions action=new Actions(driver);
  
  action.moveToElement(contactsLink).perform();
  
  newContact.click();
  
  }
  
  
  
  }
 