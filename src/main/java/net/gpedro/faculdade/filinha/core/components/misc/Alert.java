package net.gpedro.faculdade.filinha.core.components.misc;

import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.UI;

/**
 * Classe para facilitar o uso das notificações do Framework
 * 
 * @author gpedro<gpedro831@gmail.com>
 */
public class Alert {

    /**
     * Abstração para construir as notificações de modo seguro
     * 
     * @param caption
     * @param description
     * @param type
     * @return
     */
    private static Notification base(String caption, String description,
            Type type) {
        return (description == null) ? new Notification(caption, type)
                : new Notification(caption, description, type);
    }

    /**
     * Pré-montar uma notificação de aviso (amarelo)
     * 
     * @param caption
     * @param description
     * @return Notification
     */
    public static Notification warn(String caption, String description) {
        return base(caption, description, Type.WARNING_MESSAGE);
    }

    /**
     * Pré-montar uma notificação de erro (vermelho)
     * 
     * @param caption
     * @param description
     * @return Notification
     */
    public static Notification error(String caption, String description) {
        return base(caption, description, Type.ERROR_MESSAGE);
    }

    /**
     * Pré-montar uma notificação de informação no canto inferior direito
     * 
     * @param caption
     * @param description
     * @return Notification
     */
    public static Notification info(String caption, String description) {
        return base(caption, description, Type.TRAY_NOTIFICATION);
    }

    /**
     * Pré-montar uma notificação de sucesso no meio da tela
     * 
     * @param caption
     * @param description
     * @return Notification
     */
    public static Notification success(String caption, String description) {
        return base(caption, description, Type.HUMANIZED_MESSAGE);
    }

    /**
     * Monta e mostra uma notificação de aviso (amarelo)
     * 
     * @param caption
     * @param description
     */
    public static void showWarn(String caption, String description) {
        Notification alert = warn(caption, description);
        alert.show(UI.getCurrent().getPage());
    }

    /**
     * Monta e mostra uma notificação de erro (vermelho)
     * 
     * @param caption
     * @param description
     */
    public static void showError(String caption, String description) {
        Notification alert = error(caption, description);
        alert.show(UI.getCurrent().getPage());
    }

    /**
     * Monta e mostra de informação no canto inferior direito
     * 
     * @param caption
     * @param description
     */
    public static void showInfo(String caption, String description) {
        Notification alert = info(caption, description);
        alert.show(UI.getCurrent().getPage());
    }

    /**
     * Monta e mostra de sucesso no meio da tela
     * 
     * @param caption
     * @param description
     */
    public static void showSuccess(String caption, String description) {
        Notification alert = success(caption, description);
        alert.show(UI.getCurrent().getPage());
    }
}
