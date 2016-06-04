package org.vaadin.tkspring;

import com.moscaville.orderapp.FirebaseConnection;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.addon.touchkit.ui.NavigationManager;
import com.moscaville.ui.MenuView;
import org.springframework.beans.factory.annotation.Autowired;

@Theme("touchkit")
@SpringUI
// If not using cdn.virit.in, uncomment following annotation and vaadin plugin
// from pom.xml
//@Widgetset("AppWidgetset")
public class MainUI extends UI {

    @Autowired
    FirebaseConnection firebaseConnection;
    
    @Override
    protected void init(VaadinRequest request) {

        NavigationManager navigationManager = new NavigationManager();
        MenuView menuView = new MenuView();
        navigationManager.navigateTo(menuView);

        setContent(navigationManager);
    }
}
