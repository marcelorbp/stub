package ie.pensionsauthority.core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory implements WebDriverProvider {

	private static final Logger logger = LoggerFactory.getLogger(WebDriverFactory.class);
	private static final String DEFAULT_GRID_URL = "http://localhost:4444/wd/hub"; // TODO parametrize this

	@Override
	public WebDriver create(String executionLocation, String browserType) {
		
//		System.setProperty("otel.traces.exporter", "jaeger");
//		System.setProperty("otel.exporter.jaeger.endpoint", "http://localhost:14250");
//		System.setProperty("otel.resource.attributes", "service.name=selenium-java-client");
		
		if (executionLocation == null || browserType == null) {
			throw new IllegalArgumentException("Execution location and browser type must not be null.");
		}

		String location = executionLocation.trim().toLowerCase();
		String type = browserType.trim().toLowerCase();

		logger.info(String.format("Creating WebDriver - Location: %s, Type: %s", location, type));

		switch (location) {
		case "local":
			return createLocalDriver(type);
		case "grid":
			return createRemoteDriver(type);
		default:
			throw new IllegalArgumentException("Unsupported execution location: " + location);
		}
	}

	private WebDriver createLocalDriver(String type) {
		switch (type) {
		case "chrome":
			logger.info("Launching local ChromeDriver...");
			return new ChromeDriver(getChromeOptions());
		case "firefox":
			logger.info("Launching local FirefoxDriver...");
			return new FirefoxDriver(getFirefoxOptions());
		case "edge":
			logger.info("Launching local EdgeDriver...");
			return new EdgeDriver(getEdgeOptions());
		default:
			throw new IllegalArgumentException("Unsupported browser type for local execution: " + type);
		}
	}

	private WebDriver createRemoteDriver(String type) {
		String gridUrl = DEFAULT_GRID_URL;
		try {
			switch (type) {
			case "chrome":
				logger.info("Launching Chrome RemoteWebDriver with URL: " + gridUrl);
				return new RemoteWebDriver(new URL(gridUrl), getChromeOptions());
			case "firefox":
				logger.info("Launching Firefox RemoteWebDriver with URL: " + gridUrl);
				return new RemoteWebDriver(new URL(gridUrl), getFirefoxOptions());
			case "edge":
				logger.info("Launching Edge RemoteWebDriver with URL: " + gridUrl);
				return new RemoteWebDriver(new URL(gridUrl), getEdgeOptions());
			default:
				throw new IllegalArgumentException("Unsupported browser type for grid execution: " + type);
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Invalid Grid URL: " + gridUrl, e);
		}
	}

	private ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		if (Boolean.getBoolean("webdriver.headless")) {
			options.addArguments("--headless=new");
		}
		return options;
	}

	private FirefoxOptions getFirefoxOptions() {
		FirefoxOptions options = new FirefoxOptions();
		if (Boolean.getBoolean("webdriver.headless")) {
			options.addArguments("-headless");
		}
		return options;
	}

	private EdgeOptions getEdgeOptions() {
		EdgeOptions options = new EdgeOptions();
		if (Boolean.getBoolean("webdriver.headless")) {
			options.addArguments("--headless=new");
		}
		return options;
	}
}