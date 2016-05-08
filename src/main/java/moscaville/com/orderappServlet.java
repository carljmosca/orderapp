package moscaville.com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.vaadin.addon.touchkit.server.TouchKitServlet;
import com.vaadin.server.SessionInitEvent;

@SuppressWarnings("serial")
@WebServlet("/*")
public class orderappServlet extends TouchKitServlet {

    private final orderappUIProvider uiProvider = new orderappUIProvider();

    @Override
    protected void servletInitialized() throws ServletException {
        super.servletInitialized();
        getService().addSessionInitListener((SessionInitEvent event) -> {
            event.getSession().addUIProvider(uiProvider);
        });
    }

}
