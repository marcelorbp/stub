package ie.pensionsauthority.core.configuration;

public class Environment {
	private String name;
	private String appUrl;
	private String apiUrl;
	private String dbConnectionString;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getDbConnectionString() {
		return dbConnectionString;
	}

	public void setDbConnectionString(String dbConnectionString) {
		this.dbConnectionString = dbConnectionString;
	}

}
