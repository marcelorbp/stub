package ie.pensionsauthority.core.ui.imp.web;

import org.openqa.selenium.By;

import ie.pensionsauthority.core.application.Application;
import ie.pensionsauthority.core.ui.element.Button;
import ie.pensionsauthority.core.ui.element.CheckBox;
import ie.pensionsauthority.core.ui.element.DropDown;
import ie.pensionsauthority.core.ui.element.ElementSelector;
import ie.pensionsauthority.core.ui.element.InputTextBox;
import ie.pensionsauthority.core.ui.element.RadioButton;

public class ElementsSelectorImpWeb implements ElementSelector<By> {

	private Application app;
	
	public ElementsSelectorImpWeb(Application app) {
		this.app = app;
	}
	
	@Override
	public Button getButton(By locator) {
		return new ButtonImpWeb(app,locator);
	}

	@Override
	public InputTextBox getInputTextBox(By locator) {
		return new InputTextBoxImpWeb(app, locator);
	}

	@Override
	public DropDown getDropDown(By locator) {
		return new DropdownImpWeb(app, locator);
	}

	@Override
	public CheckBox getCheckBox(By locator) {
		return new CheckBoxImpWeb(app, locator);
	}

	@Override
	public RadioButton getRadioButton(By locator) {
		return new RadioButtonImpWeb(app, locator);
	}	

}
