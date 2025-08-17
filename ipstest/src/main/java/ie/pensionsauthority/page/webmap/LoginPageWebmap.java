package ie.pensionsauthority.page.webmap;

import org.openqa.selenium.By;

import ie.pensionsauthority.core.application.Application;
import ie.pensionsauthority.core.ui.element.Button;
import ie.pensionsauthority.core.ui.element.InputTextBox;
import ie.pensionsauthority.core.ui.imp.web.ElementsSelectorImpWeb;
import ie.pensionsauthority.page.model.LoginPageModel;

public class LoginPageWebmap implements LoginPageModel {

	ElementsSelectorImpWeb selector;

	static final By cssPageSpinner =	By.cssSelector("div#spinner");
	static final By cssUsername =		By.cssSelector("input#email");
	static final By cssPassword = 		By.cssSelector("input#password");
	static final By cssLoginButton =	By.cssSelector("div#login");

	public LoginPageWebmap(Application app) {
		selector = new ElementsSelectorImpWeb(app);
	}

	
	@Override
	public Button getPageSpinner() {
		// TODO Auto-generated method stub
		return null;
	}	
	
	@Override
	public InputTextBox getUsername() {
		return selector.getInputTextBox(cssUsername);
	}

	@Override
	public InputTextBox getPassword() {
		return selector.getInputTextBox(cssPassword);
	}

	@Override
	public Button getLoginBtn() {
		return selector.getButton(cssLoginButton);
	}



}
