package ie.pensionsauthority.core.ui.element;

public interface ElementSelector<L> {

	Button getButton(L locator);

	CheckBox getCheckBox(L locator); 
	
	DropDown getDropDown(L locator);
	
	InputTextBox getInputTextBox(L locator);
	
	RadioButton getRadioButton(L locator);
 
}
