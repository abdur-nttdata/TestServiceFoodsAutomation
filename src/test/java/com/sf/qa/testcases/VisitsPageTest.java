package com.sf.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sf.qa.base.TestBase;
import com.sf.qa.pageobjects.HomePage;
import com.sf.qa.pageobjects.LoginPage;

public class VisitsPageTest extends TestBase{
	
	LoginPage lp;
	HomePage hp;

	
	@Test
	public void verifyHomePage() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		lp.enterCredentials(prop.getProperty("username"), prop.getProperty("password"));
		//TODO
	}


}
