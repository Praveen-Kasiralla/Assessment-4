package pageobject;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import reusable.WebDriverHelper;
import uistore.TermsAndConditionsPageUi;
import utility.ExtentReport;
import utility.Logs;

public class TermsAndConditionsPage {
	public WebDriver driver;
	public WebDriverHelper webDriver;
	public ExtentReport exReport;
	public Logs logs = new Logs();

	public TermsAndConditionsPage(WebDriver driverr, WebDriverHelper webDriverr, ExtentReport exReportt) {
		driver = driverr;
		webDriver = webDriverr;
		exReport = exReportt;
		logs.createLogger(HomePage.class);
	}
	public void pageContains(String articalName) throws IOException {
		exReport.enterInfoLog("Checking if terms and conditions contains "+articalName);
		logs.enterInfoLog("Checking if terms and conditions contains "+articalName);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		List<WebElement> arr = webDriver.getMultipleText(driver, TermsAndConditionsPageUi.userSubmitions);
		boolean contains = false;
		for(WebElement element : arr) {
			if(element.getText().contains(articalName)) {
				exReport.enterPassLogWithSnap(articalName+" is in the terms and conditions");
				logs.enterInfoLog(articalName+" is in the terms and conditions");
				contains = true;
				Assert.assertTrue(true);
				break;
			}
		}
		if(!contains) {
			exReport.enterPassLogWithSnap(articalName+" is not in the terms and conditions");
			logs.enterInfoLog(articalName+" is not in the terms and conditions");
			Assert.assertTrue(false);
		}
	}
}
