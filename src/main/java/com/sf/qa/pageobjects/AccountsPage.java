package com.sf.qa.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sf.qa.base.TestBase;
import com.sf.qa.utils.CommonPage;
import com.sf.qa.utils.TestUtil;

public class AccountsPage extends TestBase{
	
	WebDriver driver;
	CommonPage cp = new CommonPage();
	WebDriverWait wait;
	
	@FindBy(xpath="//span[text()='Cases']/parent::a")
	WebElement casesLink;
	
	
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.EXPLICIT_WAIT));
	}
	
	public void navigateTo(String url) {
		driver.navigate().to(url);
	}

}
