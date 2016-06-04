package com.moscaville.orderapp.ui;

import com.moscaville.orderapp.template.OrderItemTemplate;
import com.vaadin.addon.touchkit.ui.EmailField;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.data.Property;
import com.vaadin.ui.Button;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MenuView extends NavigationView  {
    
    private VerticalComponentGroup content;
    private VerticalLayout itemLayout;
    
    @Autowired
    OrderItemTemplate orderItemTemplate;

    public MenuView() {
    }

    @PostConstruct
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
        nsMenuItems.addItems(orderItemTemplate.listOrderItems());
        content.addComponent(nsMenuItems);
        nsMenuItems.addValueChangeListener((Property.ValueChangeEvent event) -> {
            addMenuItemSelection();
        });
        itemLayout = new VerticalLayout();
        content.addComponent(itemLayout);
        
//        NavigationButton button = new NavigationButton("Add Item");
//        button.addClickListener((NavigationButtonClickEvent event) -> {
//            getNavigationManager().navigateTo(new ItemView());
//        });
//        content.addComponent(button);
        
        final Table tblItems = new Table();
        //tblItems.setContainerDataSource(tblItems);
        content.addComponent(tblItems);
        
        setContent(content);
    }
    
    private void addMenuItemSelection() {
        final NativeSelect nsOptionOne = new NativeSelect("Option One");
        nsOptionOne.addItem("testxxxx");
        itemLayout.addComponent(nsOptionOne);
        NativeButton btnAdd = new NativeButton("Add");
        itemLayout.addComponent(btnAdd);
        btnAdd.addClickListener((Button.ClickEvent event) -> {
            itemLayout.removeAllComponents();
        });
    }

}
