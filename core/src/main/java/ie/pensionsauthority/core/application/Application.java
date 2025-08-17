package ie.pensionsauthority.core.application;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public interface Application {
	String getName();

	Duration getActionTimeOut();

	Duration getActionPolling();
	
	WebDriver getDriver();

	void initialize();

	void terminate();
}
