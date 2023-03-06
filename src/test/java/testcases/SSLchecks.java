package testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PageObjects.webElements;
import utilities.BaseClass;

public class SSLchecks extends BaseClass {
	
	
	@Test(priority =1, groups = {"Rating"})
	public void Wynisco() throws WebDriverException, IOException, InterruptedException {
		webElements elements = new webElements(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		wait.until(ExpectedConditions.visibilityOf(elements.Enter_URL)).sendKeys(Wynisco);
		wait.until(ExpectedConditions.visibilityOf(elements.Submit)).click();
		wait.until(ExpectedConditions.visibilityOf(elements.WebsiteRating)).getText();
		takeScreenshot("Wynisco");
		logger.info("Wynisco Rating is: " + wait.until(ExpectedConditions.visibilityOf(elements.WebsiteRating)).getText());
	
	}
	
	@Test(priority =2, groups = {"Rating"})
	public void VishwasaHolidays() throws WebDriverException, IOException, InterruptedException {
		
		webElements elements = new webElements(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		wait.until(ExpectedConditions.visibilityOf(elements.Enter_URL)).sendKeys(VishwasaHolidays);
		wait.until(ExpectedConditions.visibilityOf(elements.Submit)).click();
		wait.until(ExpectedConditions.visibilityOf(elements.VishwasaRating)).getText();
		takeScreenshot("VishwasaHolidays");
		logger.info("VishwasaHolidays Rating is: " + wait.until(ExpectedConditions.visibilityOf(elements.VishwasaRating)).getText());

	}
	

}
