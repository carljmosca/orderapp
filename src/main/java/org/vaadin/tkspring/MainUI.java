package org.vaadin.tkspring;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.addon.touchkit.ui.NavigationManager;
import moscaville.com.ui.MenuView;

@Theme("touchkit")
@SpringUI
// If not using cdn.virit.in, uncomment following annotation and vaadin plugin
// from pom.xml
//@Widgetset("AppWidgetset")
public class MainUI extends UI {

    @Override
    protected void init(VaadinRequest request) {

        NavigationManager navigationManager = new NavigationManager();
        MenuView menuView = new MenuView();
        navigationManager.navigateTo(menuView);

        setContent(navigationManager);
    }
}
