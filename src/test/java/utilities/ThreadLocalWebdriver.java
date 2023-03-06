package utilities;

import org.openqa.selenium.WebDriver;

public class ThreadLocalWebdriver {
	public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return webDriver.get();
	}

	static WebDriver setWebDriver(WebDriver driver) {
		webDriver.set(driver);
		return driver;
	}

	static void waitWebDriver(WebDriver driver) {

	}
}
