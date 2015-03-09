package net.gpedro.faculdade.filinha;

import javax.servlet.annotation.WebServlet;

import net.gpedro.faculdade.filinha.modules.login.view.LoginView;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@Theme("mytheme")
@Widgetset("net.gpedro.faculdade.filinha.MyAppWidgetset")
public class MainApplication extends UI {
    private static final long serialVersionUID = -2055534297896559277L;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(new LoginView());
    }

    @WebServlet(urlPatterns = "/*", name = "MainServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MainApplication.class, productionMode = false)
    public static class MainServlet extends VaadinServlet {
        private static final long serialVersionUID = 5637646932206709496L;
    }
}
