package ie.pensionsauthority.page.functions;

import ie.pensionsauthority.core.application.Application;
import ie.pensionsauthority.page.model.BingHomePageModel;
import ie.pensionsauthority.page.webmap.BingHomePageWebmap;

public class BingHomepageFunctions {
	
		private final BingHomePageModel pageModel;
		private final Application app;

		public BingHomepageFunctions(Application app) {
			this.app = app;
			this.pageModel = new BingHomePageWebmap(this.app);
		}
		
		public void populateSearchField(String search) {
			pageModel.getSearchField().getElementManipulator().enterText(search);
		}

		public void clickSearchButton() {
			pageModel.getSearchButton().getElementManipulator().click();
		}		
}
