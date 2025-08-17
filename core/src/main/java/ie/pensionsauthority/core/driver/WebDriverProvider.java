package ie.pensionsauthority.core.driver;


import org.openqa.selenium.WebDriver;

public interface WebDriverProvider {
    WebDriver create(String executionLocation, String browserType);
}