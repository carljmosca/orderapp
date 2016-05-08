package moscaville.com;

import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UIProvider;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class orderappUIProvider extends UIProvider {

    @Override
    public Class<? extends UI> getUIClass(UIClassSelectionEvent event) {

        boolean mobileUserAgent = false;
        boolean mobileParameter = false;
        try {
            mobileUserAgent = event.getRequest().getHeader("user-agent")
                    .toLowerCase().contains("mobile");
            mobileParameter = event.getRequest().getParameter("mobile") != null;
        } catch (Exception e) {

        }

        if (overrideMobileUA() || mobileUserAgent || mobileParameter) {
            return orderappTouchKitUI.class;
        } else {
            return orderappFallbackUI.class;
        }
    }

    private boolean overrideMobileUA() {
        VaadinSession session = VaadinSession.getCurrent();
        return session != null && session.getAttribute("mobile") != null;
    }
}
