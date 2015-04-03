package net.gpedro.faculdade.filinha.core.abstracts;

import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class AbstractPopupView<T extends AbstractModel> extends Window {

    private AbstractView<T> v;

    public AbstractPopupView(T entity, Class<T> objClass) {
        if (entity == null) { return; }

        v = new AbstractView<T>(objClass) {};
        v.bean.setItemDataSource(entity);
        v.build();

        v.setMargin(true);
        v.setSpacing(true);
        
        setCaption("Visualizando #" + entity.getId());
        setWidth(30, Unit.PERCENTAGE);
        setContent(v);
        setModal(true);
    }

}
