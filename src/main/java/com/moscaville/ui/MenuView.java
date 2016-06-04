package com.moscaville.ui;

import com.moscaville.model.OrderItem;
import com.vaadin.addon.touchkit.ui.EmailField;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.data.Property;
import com.vaadin.ui.Button;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class MenuView extends NavigationView {
    
    private final List<OrderItem> orderItems;
    private VerticalComponentGroup content;

    public MenuView() {
        orderItems = new ArrayList<>();
        OrderItem orderItem = new OrderItem();
        orderItem.setDescription("test");
        orderItems.add(orderItem);
        orderItem = new OrderItem();
        orderItem.setDescription("test2");
        orderItems.add(orderItem);
        createComponents();
    }

    private void createComponents() {
        setCaption("Menu");

        content = new VerticalComponentGroup();

        final TextField nameField = new TextField("Name");
        nameField.setInputPrompt("Enter your name...");
        content.addComponent(nameField);

        final EmailField emailField = new EmailField("Email");
        emailField.setInputPrompt("Enter your email address...");
        content.addComponent(emailField);

        final NativeSelect nsMenuItems = new NativeSelect("Menu Item");
        nsMenuItems.addItems(orderItems);
        content.addComponent(nsMenuItems);
        nsMenuItems.addValueChangeListener((Property.ValueChangeEvent event) -> {
            addMenuItemSelection();
        });
        
//        NavigationButton button = new NavigationButton("Add Item");
//        button.addClickListener((NavigationButtonClickEvent event) -> {
//            getNavigationManager().navigateTo(new ItemView());
//        });
//        content.addComponent(button);
        
        
        setContent(content);
    }
    
    private void addMenuItemSelection() {
        VerticalLayout vl = new VerticalLayout();
        final NativeSelect nsOptionOne = new NativeSelect("Option One");
        nsOptionOne.addItem("testxxxx");
        vl.addComponent(nsOptionOne);
        NativeButton btnAdd = new NativeButton("Add");
        vl.addComponent(btnAdd);
        content.addComponent(vl);
        btnAdd.addClickListener((Button.ClickEvent event) -> {
            content.removeComponent(vl);
        });
    }

}
