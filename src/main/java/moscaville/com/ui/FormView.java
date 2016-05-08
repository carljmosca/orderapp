package moscaville.com.ui;

import com.vaadin.addon.touchkit.ui.DatePicker;
import com.vaadin.addon.touchkit.ui.EmailField;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui. ListSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class FormView extends NavigationView {

    public FormView() {
        createComponents();
    }
    
    private void createComponents() {
        setCaption("Form");
        final VerticalComponentGroup content = new VerticalComponentGroup();

        final TextField nameField = new TextField("Name");
        nameField.setInputPrompt("Enter your name...");
        content.addComponent(nameField);

        final EmailField emailField = new EmailField("Email");
        emailField.setInputPrompt("Enter your email address...");
        content.addComponent(emailField);
        
        List<String> strings = new ArrayList<>();
        strings.add("Test 1");
        strings.add("Test 2");
        for (int i = 0; i < 20; i++) strings.add("Item "+ i);
        ListSelect nsCoatings = new ListSelect("Coatings", strings);
        nsCoatings.setMultiSelect(true);
        content.addComponent(nsCoatings);

        final Button submitButton = new Button("Submit");
        submitButton.addClickListener((ClickEvent event) -> {
            Notification.show("Thanks!");
        });

        
        setContent(new CssLayout(content, submitButton));
    }

}
