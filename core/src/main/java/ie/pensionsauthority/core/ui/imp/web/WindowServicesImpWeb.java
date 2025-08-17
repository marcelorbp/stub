package ie.pensionsauthority.core.ui.imp.web;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ie.pensionsauthority.core.application.Application;
import ie.pensionsauthority.core.ui.element.Window;

public class WindowServicesImpWeb implements Window {
    private static final Logger logger = LoggerFactory.getLogger(WindowServicesImpWeb.class);
    
	private final Application app;
	private final By locator;
	private final Duration timeout;
	private final Duration polling;
	private final WebDriver driver;
	private final FluentWait<WebDriver> wait;

	
	private ArrayList<String> previouswindows = null;
	private ArrayList<String> currentwindows = null;

	public WindowServicesImpWeb(Application app, By locator) {
		this.app = app;
		this.locator = locator;
		this.timeout = app.getActionTimeOut();
		this.polling = app.getActionPolling();
		this.driver = app.getDriver();
		this.wait = new FluentWait<WebDriver>(driver)
				.withTimeout(timeout)
				.pollingEvery(polling);
	}
	
	
	// Enumerates the open windows
	private void EnumWindows() {
		previouswindows = currentwindows;
		logger.trace("Previous browser handles: " + previouswindows);
		currentwindows = new ArrayList<String>(driver.getWindowHandles());
		logger.trace("Current browser handles: " + currentwindows);
	}
	
	// Gets the Parent window
	private String getParentWindow() {
		EnumWindows();
		String parent = currentwindows.get(0);
		return parent;
	}	
	
	
	// Gets the Child window
	private String getChildWindow(int childIndex) {
		EnumWindows();
		String child = currentwindows.get(childIndex);
		return child;
	}
	

	@Override
	public void acceptWindowAlert() {
		logger.debug("Accepting browser alert.");
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					String alertText = driver.switchTo().alert().getText();
	                logger.trace("Alert text - [{}]", alertText);
					driver.switchTo().alert().accept();
					return true;
				} catch (Exception e) {
					logger.error("Error accepting browser alert", e.getMessage(), e);
					return false;
				}
			}
		});

	}

	@Override
	public void printWindowCount() {
		logger.debug("Getting count of open browser windows");
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					EnumWindows();
					int newCount = currentwindows.size();
					int oldCount = previouswindows.size();
					
					logger.trace("Currentwindows.size() " + newCount);
					logger.trace("Ppreviouswindows.size() " + oldCount);
					return true;
				} catch (Exception e) {
					logger.error("Error getting count of open browser windows", e.getMessage(), e);
					return false;
				}
			}
		});
	}

	@Override
	public void switchToParentWindow() {
		logger.debug("Switching focus to application's browser parent window");
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					driver.switchTo().window(getParentWindow());
					return true;
				} catch (Exception e) {
					logger.error("Error switching focus to application's browser parent window", e.getMessage(), e);
					return false;
				}
			}
		});
	}

	@Override
	public void switchToChildXWindow(int childIndex) {
		logger.debug("Switching focus to application's browser child window.");
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					EnumWindows();
					driver.switchTo().window(getChildWindow(childIndex));
					return true;
				} catch (Exception e) {
					logger.error("Error switching focus to application's browser child [{}] window",childIndex, e.getMessage(), e);
					return false;
				}
			}
		});
	}

	@Override
	public void switchToChildXWindow() {
		logger.debug("Switching focus to application's browser child window.");
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					EnumWindows();
					String parentWindow = driver.getWindowHandle();
					Set<String> handles = driver.getWindowHandles();
					for (String handle : handles) {
						if (!handle.equalsIgnoreCase(parentWindow))
						driver.switchTo().window(handle);
					}
					return true;
				} catch (Exception e) {
					logger.error("Error switching focus to application's browser child window", e.getMessage(), e);
					return false;
				}
			}
		});
	}

	@Override
	public void switchToFrame() {
		logger.debug("Switching focus to application's browser iframe with locator - " + locator);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					WebElement element = driver.findElement(locator);
					driver.switchTo().frame(element);
					return true;
				} catch (Exception e) {
					logger.error("Error witching focus to application's browser iframe with locator [{}]",locator, e.getMessage(), e);
					return false;
				}
			}
		});
	}

	@Override
	public void switchToDefaultFrame() {
		logger.debug("Switching focus to application's default browser frame");
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					driver.switchTo().defaultContent();
					return true;
				} catch (Exception e) {
					logger.error("Error switching focus to application's default browser frame", e.getMessage(), e);
					return false;
				}
			}
		});
	}

	@Override
	public void maximiseCurrentWindow() {
		logger.debug("Maximising application current window");
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					driver.manage().window().maximize();
					return true;
				} catch (Exception e) {
					logger.error("Error switching focus to application's default browser frame", e.getMessage(), e);
					return false;
				}
			}
		});
	}

	@Override
	public String getURL() {
		logger.debug("Getting URL of current page.");
		String url = driver.getCurrentUrl();
		logger.debug("Current URL is [{}] ", url);
		return url;
	}

	@Override
	public String getTitle() {
		logger.debug("Getting Title of current page.");
		String title = driver.getTitle();
		logger.debug("Current Title is [{}] ", title);
		return title;
	}

	@Override
	public void closeCurrentWindow() {
		logger.debug("Closing current window");
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					driver.close();
					return true;
				} catch (Exception e) {
					logger.error("Error closing current window", e.getMessage(), e);
					return false;
				}
			}
		});
	}

	@Override
	public void navigateToNewURL(String url) {
		logger.debug("Navigating to new URL.");
		driver.navigate().to(url);
	}

	@Override
	public void navigateBack() {
		logger.debug("Clicking on Back button on current window");
		driver.navigate().back();
	}

	@Override
	public void navigateForward() {
		logger.debug("Clicking on Forward button on current window");
		driver.navigate().forward();
	}

	@Override
	public void pageRefresh() {
		logger.debug("Refresh the current page.");
		driver.navigate().refresh();
	}
	

}
