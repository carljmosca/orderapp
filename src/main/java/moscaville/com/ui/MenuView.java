package moscaville.com.ui;

import com.vaadin.addon.touchkit.ui.NavigationButton;
import com.vaadin.addon.touchkit.ui.NavigationButton.NavigationButtonClickEvent;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;

@SuppressWarnings("serial")
public class MenuView extends NavigationView {

    public MenuView() {
        createComponents();
    }
    
    private void createComponents() {
        setCaption("Menu");

        final VerticalComponentGroup content = new VerticalComponentGroup();
        NavigationButton button = new NavigationButton("Form");
        button.addClickListener((NavigationButtonClickEvent event) -> {
            getNavigationManager().navigateTo(new FormView());
        });
        content.addComponent(button);
        setContent(content);
    };
}
