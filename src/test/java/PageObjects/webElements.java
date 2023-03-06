package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseClass;

public class webElements extends BaseClass {

	public webElements(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// SSL Checks

	@FindBy(xpath = "//tbody/tr[1]/td[2]/input[1]")
	public WebElement Enter_URL;

	@FindBy(xpath = "//tbody/tr[1]/td[3]/input[1]")
	public WebElement Submit;
	
	@FindBy(xpath = "//*[@id='multiTable']/tbody/tr[3]/td[4]/div")
	public WebElement Rating;
	

	
	@FindBy(xpath = "//*[@id='gradeA']")
	public WebElement WebsiteRating;
	
	@FindBy(xpath = "//*[@id=\"multiTable\"]/tbody/tr[3]/td[4]/div")
	public WebElement VishwasaRating;
	

	
	

	
}
