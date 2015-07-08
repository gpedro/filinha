package net.gpedro.faculdade.filinha.core.util;

import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;

public class Session {

    public static void setAttribute(String name, Object value) {
	VaadinSession.getCurrent().setAttribute(name, value);
    }

    public static Object getAttribute(String name, Object defaults) {
	Object value = VaadinSession.getCurrent().getAttribute(name);
	return (value == null) ? defaults : value;
    }

    public static Object getAttribute(String name) {
	return VaadinSession.getCurrent().getAttribute(name);
    }

    public static boolean isLogado() {
	return (boolean) getAttribute("logado", false);
    }
    
    public static void logout() {
	setAttribute("logado", false);
	setAttribute("usuario", null);
	
	Page.getCurrent().reload();
    }
}
