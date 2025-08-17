package ie.pensionsauthority.core.ui.imp.web;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

import ie.pensionsauthority.core.application.Application;
import ie.pensionsauthority.core.ui.element.ElementManipulator;

public class ElementManipulatorImpWeb implements ElementManipulator {
	
	private static final Logger logger = LoggerFactory.getLogger(ElementManipulatorImpWeb.class);

	protected final Application app;
	protected final By locator;
	protected final Duration timeout;
	protected final Duration polling;
	protected final WebDriver driver;
	protected final FluentWait<WebDriver> wait;	

	
	public ElementManipulatorImpWeb(Application app, By locator) {
		this.app = app;
		this.locator = locator;
		this.timeout = app.getActionTimeOut();
		this.polling = app.getActionPolling();
		this.driver = app.getDriver();
		this.wait = new FluentWait<WebDriver>(driver)
				.withTimeout(timeout)
				.pollingEvery(polling);
	}
	
	
	/**
	 * Attempts to click on the web element identified by the locator.
	 * 
	 * <p>This method performs the following steps:</p>
	 * <ol>
	 *   <li>Waits for the element to be present in the DOM using the provided locator.</li>
	 *   <li>Waits until the element is clickable (i.e., visible and enabled).</li>
	 *   <li>Attempts to click the element.</li>
	 *   <li>If an exception occurs during any step, logs the error and retries until the timeout is reached.</li>
	 * </ol>
	 *
	 * <p>This method is useful in dynamic web pages where elements may take time to become interactable due to
	 * animations, AJAX calls, or delayed rendering.</p>
	 *
	 * @throws TimeoutException if the element is not clickable within the specified wait duration
	 */
	public void click() {
	    logger.debug("Clicking on element with locator: {}", locator);

	    wait.until(new Function<WebDriver, Boolean>() {
	        @Override
	        public Boolean apply(WebDriver driver) {
	            try {
	                WebElement element = driver.findElement(locator);
	                element.click();
	                logger.debug("Successfully clicked on element: {}", locator);
	                return true;
	            } catch (Exception e) {
	                logger.error("Retrying click on element [{}] due to exception: {}", locator, e.getMessage());
	                return false; // Retry until timeout
	            }
	        }
	    });
	}

	
	/**
	 * This method sends the KEYS to the element
	 * 
	 * @param String Text to send to the WebElement
	 * 
	 */
	@Override
	public void enterText(String text) {
		logger.debug("Entering text '{}' into element with locator - {}", text, locator);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					WebElement element = driver.findElement(locator);
					element.sendKeys(text);
					return true;
				} catch (Exception e) {
					logger.trace("Error entering text in element with locator - {}: {}", locator, e.getMessage(), e);
					return false;
				}
			}
		});
	}
}
