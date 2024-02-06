package com.sf.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sf.qa.base.TestBase;
import com.sf.qa.pageobjects.CasesPage;
import com.sf.qa.pageobjects.HomePage;
import com.sf.qa.pageobjects.LoginPage;
import com.sf.qa.utils.TestUtil;

public class CasePageTest extends TestBase {

	LoginPage lp;
	CasesPage casepage;
	TestUtil testutil;
	HomePage hp;

	@Test(dataProvider = "getCaseData")
	public void verifycreateCaseTestCase(String accountname, String caseorigin) {
		lp = new LoginPage(driver);
		casepage = new CasesPage(driver);
		hp = new HomePage(driver);
		lp.enterCredentials(prop.getProperty("username"), prop.getProperty("password"));
		lp.clickLogin();
		lp.verifyHomePageTitle();
		casepage.clickCaseLink();
		casepage.clickNewCase();
		casepage.clickNextCase();
		casepage.selectAccountName(accountname);
		casepage.selectCaseOrigin(caseorigin);
		casepage.clickSaveCase();
		casepage.verifycaseDetailPage();
		hp.clickLogout();
	}
	
	@DataProvider
	public Object[][] getCaseData() {
		testutil = new TestUtil();
		Object data[][] = testutil.getTestData("Cases");
		return data;
		
	}

}
