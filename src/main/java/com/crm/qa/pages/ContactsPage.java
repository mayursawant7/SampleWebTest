
  package com.crm.qa.pages;
  
  import java.util.List;
  
  import org.openqa.selenium.By; 
  import org.openqa.selenium.WebElement; 
  import org.openqa.selenium.interactions.Actions; 
  import org.openqa.selenium.support.FindBy; 
  import org.openqa.selenium.support.PageFactory; 
  import org.openqa.selenium.support.ui.Select;  
  import com.crm.qa.base.TestBase; 
  import com.crm.qa.util.TestUtil;
  //import com.crm.qa.util.Xls_Reader;
import com.crm.qa.util.Xls_Reader;
  
  public class ContactsPage extends TestBase{ 
	  Xls_Reader reader=new Xls_Reader("C:\\Users\\sawantm\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx");
	  HomePage homePage;
  
  @FindBy(xpath="//td[contains(text(),'Contacts')]") 
  WebElement contactLabel;
  
  @FindBy(name="title") 
  WebElement proftitle;
  
  @FindBy(id="first_name") 
  WebElement firstName;
  
  @FindBy(id="surname") 
  WebElement lastName;
  
  @FindBy(name="client_lookup") 
  WebElement companyName;
  
  @FindBy(xpath="//form[@id='contactForm']//input[@type='submit' and @value='Save' and @class='button']") 
  WebElement btnSubmit;
  
  
  
  public ContactsPage() { 
	  PageFactory.initElements(driver, this); 
  homePage=new  HomePage();
  
  }
  
  public boolean verifyContactsLabel() { 
	  return contactLabel.isDisplayed(); 
	  }
  //*****For multiple elements 
  public void selectContactByName(String name) {
  driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']"
  )).click(); 
  }
  
  public void fillNewContact(String pTitle, String fName, String lName, String  cName) { 
	 Select profTitle=new  Select(driver.findElement(By.xpath("//*[@name='title']")));
  profTitle.selectByValue(pTitle); firstName.sendKeys(fName);
  lastName.sendKeys(lName); companyName.sendKeys(cName); btnSubmit.click(); 
  }
  
  public void fillMultipleContacts() {
  
  int rowCount=reader.getRowCount("contacts"); 
  int colCount=reader.getColumnCount("contacts"); System.out.println(rowCount);
  System.out.println(colCount); for(int i=1;i<rowCount;i++) 
  { 
	  Select profTitle=new Select(proftitle);
  profTitle.selectByValue(reader.getCellData("contacts", "title", i+1));
  firstName.sendKeys(reader.getCellData("contacts", "firstname", i+1));
  lastName.sendKeys(reader.getCellData("contacts", "lastname", i+1));
  companyName.sendKeys(reader.getCellData("contacts", "company", i+1));
  btnSubmit.click(); homePage.clickOnNewContact();
  } 
  } 
  
  
  public void deleteDuplicateEntry(String user) { 
	  homePage.clickContacts();
  List<WebElement>  userDelete=driver.findElements(By.xpath("//a[contains(text(),'"+user+"')]"));
  int entryLength=userDelete.size(); 
  System.out.println(entryLength);
  if(entryLength > 1) { 
	  for(int i=0;i<entryLength-1;i++) { 
		List<WebElement> btnDeleteSingleEntry=driver.findElements(By.xpath("//a[contains(text(),'"+user+"')]//following::td[6]//a[4]")); 
  btnDeleteSingleEntry.get(0).click();
  driver.switchTo().alert().accept();   
  }
    
	/*
	 * for(WebElement value:btnDeleteSingleEntry) { value.click();
	 * driver.switchTo().alert().accept();
	 * System.out.println("Record Deleted : "+value.getText());
	 * 
	 * }
	 */
  
  }
  
  }
  
  
  }
 