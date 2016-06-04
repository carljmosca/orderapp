package com.moscaville.orderapp.ui;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.ListSelect;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class ItemView extends NavigationView {

    public ItemView() {
        createComponents();
    }

    private void createComponents() {
        setCaption("Add");
        final VerticalComponentGroup content = new VerticalComponentGroup();

        List<String> strings = new ArrayList<>();
        strings.add("Test 1");
        strings.add("Test 2");
        for (int i = 0; i < 20; i++) {
            strings.add("Item " + i);
        }
        ListSelect nsCoatings = new ListSelect("Coatings", strings);
        nsCoatings.setMultiSelect(true);
        content.addComponent(nsCoatings);

        final Button submitButton = new Button("Submit");
        submitButton.addClickListener((ClickEvent event) -> {
            getNavigationManager().navigateBack();
        });

        setContent(new CssLayout(content, submitButton));
    }

}
