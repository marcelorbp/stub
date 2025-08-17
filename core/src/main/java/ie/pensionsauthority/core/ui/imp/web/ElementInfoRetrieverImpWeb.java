package ie.pensionsauthority.core.ui.imp.web;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ie.pensionsauthority.core.application.Application;
import ie.pensionsauthority.core.ui.element.ElementInfoRetriever;

public class ElementInfoRetrieverImpWeb implements ElementInfoRetriever {
		
	private static final Logger logger = LoggerFactory.getLogger(ElementInfoRetrieverImpWeb.class);

	private final Application app;
	private final By locator;
	private final Duration timeout;
	private final Duration polling;
	private final WebDriver driver;
	private final FluentWait<WebDriver> wait;	

	
	
	public ElementInfoRetrieverImpWeb(Application app, By locator) {
		this.app = app;
		this.locator = locator;
		this.timeout = app.getActionTimeOut();
		this.polling = app.getActionPolling();
		this.driver = app.getDriver();
		this.wait = new FluentWait<WebDriver>(driver)
				.withTimeout(timeout)
				.pollingEvery(polling);
	}

}
