package ie.pensionsauthority.core.ui.imp.web;

import org.openqa.selenium.By;

import ie.pensionsauthority.core.application.Application;
import ie.pensionsauthority.core.ui.element.Button;

public class ButtonImpWeb extends UiElementServicesImpWeb implements Button {

	public ButtonImpWeb(Application app, By locator) {
		super(app, locator);
	}

}
