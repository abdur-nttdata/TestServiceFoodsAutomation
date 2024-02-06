package com.sf.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sf.qa.base.TestBase;
import com.sf.qa.pageobjects.CasesPage;
import com.sf.qa.pageobjects.HomePage;
import com.sf.qa.pageobjects.LoginPage;
import com.sf.qa.utils.TestUtil;

public class LoginPageTest extends TestBase {
	
	LoginPage lp;
	HomePage hp;
	

	@Test
	public void verifyHomePage() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		logger.info("Enter credentials");
		lp.enterCredentials(prop.getProperty("username"), prop.getProperty("password"));
		logger.info("Click Login");
		lp.clickLogin();
		logger.info("Verify Home Page");
		lp.verifyHomePageTitle();
		logger.info("Click Logout");
		hp.clickLogout();

	}

	@Test
	public void verifyHomePage_1() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		lp.enterCredentials(prop.getProperty("username"), prop.getProperty("password"));
		lp.clickLogin();
		lp.verifyHomePageTitle();
		hp.clickappLauncher();
		hp.clickLogout();
	}

}
