package com.sf.qa.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sf.qa.base.TestBase;
import com.sf.qa.utils.CommonPage;
import com.sf.qa.utils.TestUtil;

public class HomePage extends TestBase {
	WebDriver driver;
	WebDriverWait wait;
	CommonPage cp;
	
	@FindBy(xpath = "//a[text()='Log out']")
	WebElement logOut;
	@FindBy(xpath = "//div[@role='navigation']//button")
	WebElement appLaucher;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.EXPLICIT_WAIT));
	}
	
	public void clickLogout() {
		wait.until(ExpectedConditions.visibilityOf(logOut));
		logOut.click();
	}
	
	public void clickappLauncher() {
		wait.until(ExpectedConditions.visibilityOf(appLaucher));
		cp = new CommonPage();
		cp.jsclick(driver, appLaucher);
		
	}

}
