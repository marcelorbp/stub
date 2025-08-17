package ie.pensionsauthority.core.configuration;

public class RunConfig implements Config {
	private Environment environment;
	private Browser browser;

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public Browser getBrowser() {
		return browser;
	}

	public void setBrowser(Browser browser) {
		this.browser = browser;
	}

}
