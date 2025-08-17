package ie.pensionsauthority.core.ui.element;

public interface Window {

	void acceptWindowAlert();

	void printWindowCount();

	void switchToParentWindow();

	void switchToChildXWindow(int ChildIndex);
	
	void switchToChildXWindow();

	void switchToFrame();

	void switchToDefaultFrame();

	void maximiseCurrentWindow();
	
	String getURL();

	String getTitle();

	void closeCurrentWindow();

	void navigateToNewURL(String url);

	void navigateBack();

	void navigateForward();
	
	void pageRefresh();

}
