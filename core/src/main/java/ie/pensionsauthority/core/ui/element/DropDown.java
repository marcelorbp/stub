package ie.pensionsauthority.core.ui.element;

public interface DropDown extends UiElementServices{

	void selectDropDownItem(String value);

	void selectDropDownItemByIndex(int value);

	void selectSearchDropDownItem(String value);

	void selectDropDownItemByText(String value);

	void selectDropDownItemByVisibleText(String value);	

}
