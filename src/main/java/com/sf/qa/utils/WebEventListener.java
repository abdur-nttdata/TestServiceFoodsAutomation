package com.sf.qa.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.sf.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverListener, ITestListener,IAnnotationTransformer{

	public void onTestFailure(ITestResult result) {
		
		String filename = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator
				+ result.getMethod().getMethodName();
		File file = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(filename + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}

	public void afterFindElement(WebDriver driver, By locator, WebElement result) {
		// TODO Auto-generated method stub
	}

	public void afterClose(WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void afterQuit(WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void beforeGet(WebDriver driver, String url) {
		// TODO Auto-generated method stub
	}

//	public void afterGet(WebDriver driver, String url) {
//		System.out.println("After navigating to :'" + url + "'");
//	}

	public void afterGetWindowHandle(WebDriver driver, String result) {
		// TODO Auto-generated method stub
	}

	public void afterClick(WebElement element) {
		// TODO Auto-generated method stub
	}

	public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
//		System.out.println("Value '"+keysToSend.toString()+"'entered in field '"+element.toString()+"'");
		// TODO Auto-generated method stub
	}

	public void afterIsDisplayed(WebElement element, boolean result) {
		// TODO Auto-generated method stub
	}

	public void afterTo(Navigation navigation, String url) {
		// TODO Auto-generated method stub
	}

	public void afterRefresh(Navigation navigation) {
		// TODO Auto-generated method stub
	}

	public void afterGetText(Alert alert, String result) {
		// TODO Auto-generated method stub
	}

	public void onError(Object target, Method method, Object[] args, InvocationTargetException error) {
		System.out.println("Exception occured: '" + error + "'");
		try {
			TestUtil.takeScreenShot();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
