package ie.pensionsauthority.core.ui.imp.web;

import org.openqa.selenium.By;

import ie.pensionsauthority.core.application.Application;
import ie.pensionsauthority.core.ui.element.RadioButton;

public class RadioButtonImpWeb extends UiElementServicesImpWeb implements RadioButton {

	public RadioButtonImpWeb(Application app, By locator) {
		super(app, locator);
	}

}
