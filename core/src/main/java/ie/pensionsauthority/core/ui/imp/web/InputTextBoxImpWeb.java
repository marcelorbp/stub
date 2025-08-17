package ie.pensionsauthority.core.ui.imp.web;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ie.pensionsauthority.core.application.Application;
import ie.pensionsauthority.core.ui.element.InputTextBox;



public class InputTextBoxImpWeb extends UiElementServicesImpWeb implements InputTextBox {
	
	protected static final Logger logger = LoggerFactory.getLogger(InputTextBoxImpWeb.class);

	public InputTextBoxImpWeb(Application app, By locator) {
		super(app, locator);
	}
}
