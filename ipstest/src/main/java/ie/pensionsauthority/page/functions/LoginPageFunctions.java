package ie.pensionsauthority.page.functions;

import ie.pensionsauthority.core.application.Application;
import ie.pensionsauthority.page.model.LoginPageModel;
import ie.pensionsauthority.page.webmap.LoginPageWebmap;

public class LoginPageFunctions {
	
		private final LoginPageModel pageModel;
		private final Application app;

		public LoginPageFunctions(Application app) {
			this.app = app;
			this.pageModel = new LoginPageWebmap(this.app);
		}
		
		public void waitForPage() {
			pageModel.getPageSpinner().getElementObserver().waitForElementNotToBeVisible();
		}
		
		public void populateUserName(String email) {
//			ExtentListeners.testReport.get().info("Populate username: "+ email);
			pageModel.getUsername().getElementManipulator().enterText(email);
		}

		public void populatePassword(String password) {
//			ExtentListeners.testReport.get().info("Populate password: "+ password);
			pageModel.getPassword().getElementManipulator().enterText(password);
		}
		
		public void clickLoginButton() {
//			ExtentListeners.testReport.get().info("Click on Login button.");
			pageModel.getLoginBtn().getElementManipulator().click();
		}
		
		public void loginToIPS(String email, String password) {
			waitForPage();
			populateUserName(email);
			populatePassword(password);
			clickLoginButton();			
		}
}
