package ie.pensionsauthority.core.application;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ie.pensionsauthority.core.configuration.ConfigHolder;

public class WebApplication implements Application {
	private static final Logger logger = LoggerFactory.getLogger(WebApplication.class);
	private final String name;
	private final Duration timeout;
	private final Duration polling;
	private final WebDriver driver;
	
	/**
	 * Constructor. Initializes WebApplication with provided WebDriver and WindowManager.
	 * This instance of the Application that will be used for the test.
	 * 
	 */

	public WebApplication(WebDriver driver) {
		this.name = "IPS"; // TODO parametrize from data file? enum?
		this.timeout = Duration.ofSeconds(5); // TODO read from ConfigHolder like ConfigHolder.get().getTimeout();
		this.polling = Duration.ofMillis(500); // TODO read from ConfigHolder like ConfigHolder.get().getPolling();
		this.driver = driver;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Duration getActionTimeOut() {
		return timeout;
	}

	@Override
	public Duration getActionPolling() {
		return polling;
	}

	@Override
	public WebDriver getDriver() {
		return driver;
	}

	@Override
	public void initialize() {
		String homepage = ConfigHolder.get().getEnvironment().getAppUrl();
		driver.get(homepage);
	}

	@Override
	public void terminate() {
			try {
				driver.quit();
			} catch (Exception e) {
				logger.warn("Failed to quit WebDriver cleanly.", e);

		}
	}
}
