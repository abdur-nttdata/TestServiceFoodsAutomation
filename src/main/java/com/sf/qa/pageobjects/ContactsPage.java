package com.sf.qa.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sf.qa.base.TestBase;
import com.sf.qa.utils.TestUtil;

public class ContactsPage extends TestBase{
	
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(id = "username")
	WebElement usernameId;
	@FindBy(id = "password")
	WebElement passwordId;
	@FindBy(id = "Login")
	WebElement LoginId;

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.EXPLICIT_WAIT));
	}

}
