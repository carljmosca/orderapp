package moscaville.com.ui;

import com.vaadin.addon.touchkit.ui.EmailField;
import com.vaadin.addon.touchkit.ui.NavigationButton;
import com.vaadin.addon.touchkit.ui.NavigationButton.NavigationButtonClickEvent;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class MenuView extends NavigationView {

    public MenuView() {
        createComponents();
    }

    private void createComponents() {
        setCaption("Menu");

        final VerticalComponentGroup content = new VerticalComponentGroup();

        final TextField nameField = new TextField("Name");
        nameField.setInputPrompt("Enter your name...");
        content.addComponent(nameField);

        final EmailField emailField = new EmailField("Email");
        emailField.setInputPrompt("Enter your email address...");
        content.addComponent(emailField);

        NavigationButton button = new NavigationButton("Add Item");
        button.addClickListener((NavigationButtonClickEvent event) -> {
            getNavigationManager().navigateTo(new ItemView());
        });
        content.addComponent(button);
        setContent(content);
    }
;
}
