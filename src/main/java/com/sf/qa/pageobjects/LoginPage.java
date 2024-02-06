package com.sf.qa.pageobjects;

import java.time.Duration;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sf.qa.base.TestBase;
import com.sf.qa.utils.TestUtil;

public class LoginPage extends TestBase {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(id = "username")
	WebElement usernameId;
	@FindBy(id = "password")
	WebElement passwordId;
	@FindBy(id = "Login")
	WebElement LoginId;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.EXPLICIT_WAIT));
	}

	public void enterUserName(String username) {
		usernameId.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordId.sendKeys(decrypt(password));

	}

	public String decrypt(String encryptedString) {
		String decodedString = null;
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(encryptedString);
			decodedString = new String(decodedBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decodedString;
	}

	public void clickLogin() {
		LoginId.click();
	}

	public void enterCredentials(String username, String password) {
		enterUserName(username);
		enterPassword(password);
	}

	public void verifyLoginPageLoaded() {
		Assert.assertTrue(LoginId.isDisplayed(), "Login button not displayed");

	}

	public void verifyHomePageTitle() {
		wait.until(ExpectedConditions.titleContains("Home | Salesforce"));
		Assert.assertTrue(driver.getTitle().contains("Home | Salesforce"), "Home page is not displayed");
	}

}
