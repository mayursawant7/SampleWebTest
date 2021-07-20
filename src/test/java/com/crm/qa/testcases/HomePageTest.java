
  package com.crm.qa.testcases;
  
  import org.testng.annotations.AfterMethod; import
  org.testng.annotations.BeforeMethod; import org.testng.annotations.Test;
  import org.testng.asserts.SoftAssert;
  
  import com.crm.qa.base.TestBase; 
  import com.crm.qa.pages.ContactsPage; 
  import com.crm.qa.pages.HomePage; import com.crm.qa.pages.LoginPage; 
  import com.crm.qa.util.TestUtil;
  
  public class HomePageTest extends TestBase { 
	  LoginPage loginPage; 
	  HomePage homePage; ContactsPage contactsPage; TestUtil testUtil; SoftAssert
  softAssert=new SoftAssert(); public HomePageTest() { super(); }
  
  @BeforeMethod public void setUp() { intialization(); loginPage=new
  LoginPage(); testUtil=new TestUtil();
  homePage=loginPage.Login(prop.getProperty("username"),  prop.getProperty("password")); //homePage = new HomePage();
  
  }
  
  @Test(priority=1) public void verifyHomePageTitleTest() { String
  homePageTitle=homePage.verifyHomepageTitle(); 
  //SoftAssert softAssert=new  SoftAssert();
  softAssert.assertEquals(homePageTitle,
  "CRMPRO","HomePageTitleNotmatch"); softAssert.assertAll(); }
  
  @Test(priority=2) public void verifyUserNameLableTest() {
  testUtil.switchToFrame(); boolean UserNameLable=homePage.verifyUserName();
  //SoftAssert softAssert=new SoftAssert();
  softAssert.assertTrue(UserNameLable);; softAssert.assertAll(); }
  
  @Test(priority=3) public void verifyContactLinkTest() {
  testUtil.switchToFrame(); 
  contactsPage=homePage.clickContacts();
  
  }
  
  @AfterMethod public void tearDown() { 
	  driver.quit();
	  } }
 