package vn.amabuy.customedriver;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import net.thucydides.core.webdriver.DriverSource;

public class ChromeCustomeDriver implements DriverSource {

	@Override
	public WebDriver newDriver() {

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");

		final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		// options.addArguments("--headless");
		options.addArguments("--incognito");
		options.addArguments("disable-infobars");
		options.merge(capabilities);
		
		return new ChromeDriver(options);
	}

	@Override
	public boolean takesScreenshots() {
		return true;
	}
}
