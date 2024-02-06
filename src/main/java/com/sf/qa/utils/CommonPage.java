package com.sf.qa.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sf.qa.base.TestBase;

public class CommonPage extends TestBase {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.EXPLICIT_WAIT));

	public void selectDropDownValue_Lightning(WebDriver driver, String fieldName, String valuetoSelect) {

		String dropDownXpath = "//label[text()='" + fieldName + "']/following::button[1]";
		String optionXpath = "//span[@title='" + valuetoSelect + "']";

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dropDownXpath)));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(dropDownXpath))));
		driver.findElement(By.xpath(dropDownXpath)).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(optionXpath)));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(optionXpath))));
		driver.findElement(By.xpath(optionXpath)).click();
	}

	public void select_value_from_lookup_field(WebDriver driver, String valueToBeSelected, String lookupName) {
		driver.findElement(By.xpath("//label[text()='" + lookupName + "']/following::input[1]"))
				.sendKeys(valueToBeSelected);
		String windowHandle = driver.getWindowHandle();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[contains(text(),'Show All Results for')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Show All Results for')]")).click();
//		Actions act = new Actions(driver);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Show All Results for')]")));
//		act.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Show All Results for')]"))).click();

		for (String wndhndle : driver.getWindowHandles()) {

			if (!wndhndle.equals(windowHandle))

			{
				driver.switchTo().window(wndhndle);
			}

		}
//		driver.switchTo().frame("resultsFrame");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td/a[text()='" + valueToBeSelected + "']")));
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//td/a[text()='" + valueToBeSelected + "']"))));
		driver.findElement(By.xpath("//td/a[text()='" + valueToBeSelected + "']")).click();
		driver.switchTo().window(windowHandle);

	}

	public void switchToFrame(String frame) {
		driver.switchTo().frame(frame);
	}

	public void switchToDefault() {
		driver.switchTo().defaultContent();
	}

	public void jsclick(WebDriver driver, WebElement element) {
		int counter = 0;
		boolean flag = false;

		while ((!flag) && counter < 30) {
			try {
				if (element.isDisplayed())
					flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			counter = counter + 1;
		}

		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

}
