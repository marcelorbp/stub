package ie.pensionsauthority.core.ui.imp.web;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ie.pensionsauthority.core.application.Application;
import ie.pensionsauthority.core.ui.element.ElementObserver;

public class ElementObserverImpWeb implements ElementObserver {
		
	private static final Logger logger = LoggerFactory.getLogger(ElementObserverImpWeb.class);

	protected final Application app;
	protected final Duration timeout;
	protected final Duration polling;
	protected final WebDriver driver;
	protected final FluentWait<WebDriver> wait;	
	protected final By locator;
	
	public ElementObserverImpWeb(Application app, By locator) {
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
	 * Waits for the web element identified by the locator to become invisible or removed from the DOM.
	 *
	 * <p>This method is particularly useful in scenarios where you need to wait for dynamic UI elements 
	 * (such as loading spinners, overlays, or progress bars) to disappear before continuing with the next
	 * interaction. It ensures that your test does not proceed while the UI is still updating or blocking input.</p>
	 *
	 * <p>The method uses Selenium's {@code ExpectedConditions.invisibilityOfElementLocated(locator)} to 
	 * poll the DOM until one of the following is true:</p>
	 * <ul>
	 *   <li>The element is no longer attached to the DOM</li>
	 *   <li>The element is still in the DOM but is not visible</li>
	 * </ul>
	 *
	 * <p>If the element remains visible beyond the wait timeout, a {@link TimeoutException} is thrown.
	 * Any unexpected exception during the wait is logged and rethrown as a runtime exception.</p>
	 *
	 * @throws TimeoutException if the element is still visible after the maximum wait time
	 * @throws RuntimeException for any unexpected error while waiting
	 */
	@Override
	public void waitForElementNotToBeVisible() {
	    String elementDescription = locator.toString();
	    logger.debug("Waiting for invisibility of element: {}", elementDescription);

	    try {
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	        logger.debug("Element became invisible: {}", elementDescription);
	    } catch (TimeoutException e) {
	        logger.error("Timeout waiting for element to become invisible: {}", elementDescription, e);
	        throw e;
	    } catch (Exception e) {
	        logger.error("Unexpected error while waiting for invisibility of element: {}", elementDescription, e);
	        throw new RuntimeException("Failed to wait for element to become invisible", e);
	    }
	}
	
	/**
	 * Waits until the element identified by the locator is visible and enabled, making it safe to click.
	 *
	 * <p>This method is commonly used to ensure that interactive UI elements (e.g., buttons, links, input fields)
	 * are fully loaded and in a state where they can be interacted with before performing actions like {@code click()}.</p>
	 *
	 * <p>Internally, this uses Selenium's {@code ExpectedConditions.elementToBeClickable(locator)}, which checks that
	 * the element is both:</p>
	 * <ul>
	 *   <li>Present and visible on the page</li>
	 *   <li>Enabled for interaction (i.e., not disabled)</li>
	 * </ul>
	 *
	 * <p>The wait is configured to ignore {@link NoSuchElementException} to handle cases where the element may not yet
	 * exist in the DOM during the polling interval. If the element does not become clickable within the configured wait
	 * timeout, an exception will be thrown.</p>
	 *
	 * @throws TimeoutException if the element is not clickable within the wait time
	 * @throws RuntimeException for any unexpected errors encountered during the wait
	 */
	@Override
	public void waitForElementToBeClickable() {
	    logger.debug("Waiting for element to be clickable with locator: {}", locator);
	    try {
	        wait.ignoring(NoSuchElementException.class)
	            .until(ExpectedConditions.elementToBeClickable(locator));
	        logger.debug("Element is clickable: {}", locator);
	    } catch (TimeoutException e) {
	        logger.error("Timeout waiting for element to be clickable: {}", locator, e);
	        throw e;
	    } catch (Exception e) {
	        logger.error("Unexpected error while waiting for element to be clickable: {}", locator, e);
	        throw new RuntimeException("Failed to wait for element to be clickable", e);
	    }
	}

}
