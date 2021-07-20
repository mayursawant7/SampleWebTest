
  package com.crm.qa.testcases;
  
  import org.testng.annotations.AfterMethod; import
  org.testng.annotations.BeforeMethod; import org.testng.annotations.Test;
  import org.testng.asserts.SoftAssert;
  
  import com.crm.qa.base.TestBase; 
  import com.crm.qa.pages.ContactsPage; 
  import com.crm.qa.pages.HomePage; import com.crm.qa.pages.LoginPage; import
  com.crm.qa.util.TestUtil;
  
  public class ContactsPageTest extends TestBase {
  
  LoginPage loginPage; 
  HomePage homePage; 
  ContactsPage contactsPage; TestUtil
  testUtil; SoftAssert softAssert = new SoftAssert();
  
  public ContactsPageTest() { super(); }
  
  @BeforeMethod public void setUp() { 
	  intialization(); 
  loginPage = new  LoginPage(); 
  testUtil = new TestUtil(); 
  contactsPage = new ContactsPage();
  homePage = loginPage.Login(prop.getProperty("username"),  prop.getProperty("password")); testUtil.switchToFrame();
  
  }
  
  
  
  
  @Test(priority=1) public void verifyContactLableTest() { 
	  contactsPage =  homePage.clickContacts();
  softAssert.assertTrue(contactsPage.verifyContactsLabel());
  softAssert.assertAll(); }
  
  
  
  
  
  @Test(priority=2) public void selectSingleContactByName() { 
	  contactsPage =  homePage.clickContacts(); 
	  contactsPage.selectContactByName("Abe Sabian");
	  }
  
  @Test(priority=3) public void selectMultipleContactByName() { 
	  contactsPage =  homePage.clickContacts(); 
	  contactsPage.selectContactByName("Abe Sabian");
	  contactsPage.selectContactByName("AB Devilliers"); 
  }
  
  
  
  
  
  
  @Test(priority = 4) public void createNewContact() {
  homePage.clickOnNewContact(); contactsPage.fillNewContact("Dr.", "01Kane",
  "William", "NZ"); }
  
  
  
  
  
  @Test(priority = 5) public void createMultipleContact() {
  homePage.clickOnNewContact(); contactsPage.fillMultipleContacts(); }
  
  
  
  
  
  
  @Test(priority = 6) public void deleteUser() {
  contactsPage.deleteDuplicateEntry("Amar"); }
  
  
  @AfterMethod public void tearDown() { driver.quit(); }
  
  }
 