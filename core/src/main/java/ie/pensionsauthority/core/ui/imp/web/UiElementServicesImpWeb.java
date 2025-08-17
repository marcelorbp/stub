package ie.pensionsauthority.core.ui.imp.web;

import java.util.Objects;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ie.pensionsauthority.core.application.Application;
import ie.pensionsauthority.core.ui.element.ElementInfoRetriever;
import ie.pensionsauthority.core.ui.element.ElementManipulator;
import ie.pensionsauthority.core.ui.element.ElementObserver;
import ie.pensionsauthority.core.ui.element.UiElementServices;
import ie.pensionsauthority.core.ui.element.Window;
import ie.pensionsauthority.core.utils.DataManipulation;

public class UiElementServicesImpWeb implements UiElementServices {
    private static final Logger logger = LoggerFactory.getLogger(UiElementServicesImpWeb.class);

    private final Application app;
    private final By locator;
    private final Window windowServices;
    private final ElementObserver elementObserver;
    private final ElementManipulator elementManipulator;
    private final ElementInfoRetriever elementInfoRetriever;
    private final DataManipulation dataManipulation;

    public UiElementServicesImpWeb(Application app, By locator) {
        this.app = Objects.requireNonNull(app, "Application must not be null");
        this.locator = Objects.requireNonNull(locator, "Locator must not be null");        
        this.windowServices = new WindowServicesImpWeb(app, locator);
        this.elementObserver = new ElementObserverImpWeb(app, locator);
        this.elementManipulator = new ElementManipulatorImpWeb(app, locator);
        this.elementInfoRetriever = new ElementInfoRetrieverImpWeb(app, locator);
        this.dataManipulation = new DataManipulation();
    }

    @Override
    public Window getWindowServices() {
        return windowServices;
    }
    
    @Override
    public ElementObserver getElementObserver() {
        return elementObserver;
    }

    @Override
    public ElementManipulator getElementManipulator() {
        return elementManipulator;
    }

    @Override
    public ElementInfoRetriever getElementInfoRetriever() {
        return elementInfoRetriever;
    }

    @Override
    public DataManipulation getDataManipulation() {
        return dataManipulation;
    }
}
