package com.moscaville.orderapp;

import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.spring.server.SpringUIProvider;
import com.vaadin.ui.UI;
import org.springframework.web.context.WebApplicationContext;
import org.vaadin.tkspring.MainUI;

public class ParkingUIProvider extends SpringUIProvider {

    public ParkingUIProvider(WebApplicationContext webApplicationContext) {
        super(webApplicationContext);
    }

    @Override
    public Class<? extends UI> getUIClass(UIClassSelectionEvent event) {
        String userAgent = event.getRequest().getHeader("user-agent")
                .toLowerCase();

        if (userAgent.toLowerCase().contains("webkit")
                || userAgent.toLowerCase().contains("windows phone 8")
                || userAgent.toLowerCase().contains("windows phone 9")) {
            return MainUI.class;
        } else {
            return ParkingFallbackUI.class;
        }
    }

}
