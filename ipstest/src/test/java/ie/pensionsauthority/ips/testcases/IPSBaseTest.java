package ie.pensionsauthority.ips.testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ie.pensionsauthority.core.application.Application;
import ie.pensionsauthority.core.application.WebApplication;
import ie.pensionsauthority.core.configuration.ConfigHolder;
import ie.pensionsauthority.core.driver.WebDriverFactory;
import ie.pensionsauthority.core.driver.WebDriverProvider;



public class IPSBaseTest {
	protected ThreadLocal<Application> app = new ThreadLocal<Application>();
	
	@BeforeSuite(alwaysRun = true)
	public void beforeTestRun() {
		
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(ITestResult result) {
		String executionLocation = ConfigHolder.get().getBrowser().getExecutionLocation();
		String browserType = ConfigHolder.get().getBrowser().getType();	
		
		WebDriverProvider provider = new WebDriverFactory();
		
		WebApplication abc = new WebApplication(provider.create(executionLocation, browserType));
		
		app.set(abc);
		app.get().initialize();

	//	OpenTestTarget(runConfig);

	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) {
		
		app.get().terminate();
	}

	@AfterClass(alwaysRun = true)
	public void afterTestSet() {

	}

	@AfterSuite(alwaysRun = true)
	public void afterTestRun() {

	}

}
