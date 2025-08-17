package ie.pensionsauthority.core.ui.element;

import ie.pensionsauthority.core.utils.DataManipulation;

public interface UiElementServices {

	Window getWindowServices();

	ElementObserver getElementObserver();

	ElementManipulator getElementManipulator();

	ElementInfoRetriever getElementInfoRetriever();

	DataManipulation getDataManipulation();

}
