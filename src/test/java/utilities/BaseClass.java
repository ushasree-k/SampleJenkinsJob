package utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends TestData {

	ReadConfig readconfig = new ReadConfig();
	public WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeMethod
	public void setup(String br) throws Exception {

		logger = Logger.getLogger("SSL Checks");
		PropertyConfigurator.configure("log4j.properties");

		if (br.equals("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			// options.addArguments("--headless");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);

		} else if (br.equals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options);

		} else if (br.equals("edge")) {
			EdgeOptions options = new EdgeOptions();

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(options);

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ssllabs.com/ssltest/");
		logger.info("URL opened");
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        System.out.println("Current Date and Time is: " + formattedDateTime);

	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	

	// Screenshot
	public void takeScreenshot(String fileName) throws WebDriverException, IOException, InterruptedException {
		Thread.sleep(2000);
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "\\Screenshots\\" + fileName + ".jpg"));

	}
	

}
