package ie.pensionsauthority.ips.testcases;


import org.testng.annotations.Test;

import ie.pensionsauthority.page.functions.LoginPageFunctions;

public class AuthenticationTest extends IPSBaseTest{

	@Test(testName = "Login as RA user", description = "This test case validates successful login where user type is RA", groups = {"P0" })
	public void successfulLoginTest() {
		// add to argument ConcurrentHashMap<String, String> person

		LoginPageFunctions login = new LoginPageFunctions(app.get());
		login.populateUserName("myUsername");
		login.populatePassword("myPassword");
		login.clickLoginButton();
	}
	
	@Test(testName = "Fail Login as RA user", description = "This test case validates successful login where user type is RA", groups = {"P0" })
	public void failLoginTest() {
		// add to argument ConcurrentHashMap<String, String> person

		LoginPageFunctions login = new LoginPageFunctions(app.get());
		login.loginToIPS("myUsername","myPassword");
	}
}
