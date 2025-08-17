package ie.pensionsauthority.page.model;

import ie.pensionsauthority.core.ui.element.Button;
import ie.pensionsauthority.core.ui.element.InputTextBox;

public interface LoginPageModel {
	
	Button getPageSpinner();

	InputTextBox getUsername();

	InputTextBox getPassword();

	Button getLoginBtn();

}
