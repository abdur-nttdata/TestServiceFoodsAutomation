package com.sf.qa.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sf.qa.base.TestBase;
import com.sf.qa.utils.CommonPage;
import com.sf.qa.utils.TestUtil;

public class CasesPage extends TestBase {
	
	WebDriver driver;
	CommonPage cp = new CommonPage();
	WebDriverWait wait;
	
	@FindBy(xpath="//span[text()='Cases']/parent::a")
	WebElement casesLink;
	@FindBy(xpath="//div[@title='New']/parent::a")
	WebElement newCaseButton;
	@FindBy(xpath="//span[text()='Next']/parent::button")
	WebElement nextButton;
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButton;
	
	
	
	
	public CasesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.EXPLICIT_WAIT));
	}
	
	public void clickCaseLink() {
		cp.jsclick(driver, casesLink);
	}
	
	public void clickNewCase() {
		newCaseButton.click();
	}
	
	public void clickNextCase() {
		nextButton.click();
	}
	
	public void selectAccountName(String accountName) {
		cp.select_value_from_lookup_field(driver,accountName, "Account Name");
	}
	
	public void selectCaseOrigin(String value) {
		cp.selectDropDownValue_Lightning(driver,"Case Origin", value);
	}
	
	public void clickSaveCase() {
		wait.until(ExpectedConditions.visibilityOf(saveButton));
		saveButton.click();
	}
	
	public void verifycaseDetailPage() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//lightning-formatted-text[@slot='primaryField']/parent::slot/preceding::div[1]")));
		Assert.assertTrue(driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']/parent::slot/preceding::div[1]")).isDisplayed(),"Case page is not displayed");
	}
	
	
	

}
