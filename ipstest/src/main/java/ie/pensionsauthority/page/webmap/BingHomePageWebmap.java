package ie.pensionsauthority.page.webmap;

import org.openqa.selenium.By;

import ie.pensionsauthority.core.application.Application;
import ie.pensionsauthority.core.ui.element.Button;
import ie.pensionsauthority.core.ui.element.InputTextBox;
import ie.pensionsauthority.core.ui.imp.web.ElementsSelectorImpWeb;
import ie.pensionsauthority.page.model.BingHomePageModel;

public class BingHomePageWebmap implements BingHomePageModel {

	ElementsSelectorImpWeb selector;

	static final By cssSearchField     =	By.cssSelector("#sb_form_q");
	static final By cssSearchButton    =	By.cssSelector("#search_icon");

	public BingHomePageWebmap(Application app) {
		selector = new ElementsSelectorImpWeb(app);
	}

	@Override
	public InputTextBox getSearchField() {
		return selector.getInputTextBox(cssSearchField);
	}

	@Override
	public Button getSearchButton() {
		return selector.getButton(cssSearchButton);
	}
	
}
