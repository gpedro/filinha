package net.gpedro.faculdade.filinha.core.abstracts;

import java.lang.reflect.Field;

import net.gpedro.faculdade.filinha.core.annotations.VadinhoColumn;
import net.gpedro.faculdade.filinha.core.misc.VadinhoReflect;

import com.vaadin.data.Container;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public abstract class AbstractViewList<T extends AbstractModel> extends
        VerticalLayout {

    private static final long serialVersionUID = 1L;

    private Class<T> objClass;
    private Table tabela;
    protected AbstractController<T> controller;
    private Container container;

    public AbstractViewList(Class<T> objClass) {
        this.objClass = objClass;

        tabela = new Table("Listar " + objClass.getCanonicalName());
        configuraTabela();
        configuraContainer();
        configuraColunaDefault();
        configuraColunaGerada();
        configuraInterface();
    }

    protected void configuraTabela() {
        tabela.setImmediate(true);
        tabela.setWidth(100, Unit.PERCENTAGE);
    }

    protected void configuraContainer() {
        if (controller == null) { throw new NullPointerException(
                "O controller não foi iniciado ou é nulo"); }

        container = new BeanItemContainer<T>(objClass);
    }

    protected void configuraColunaDefault() {
        VadinhoReflect<T> vr = new VadinhoReflect<T>(objClass);
        for (Field field : vr.getVisibleFields()) {
            VadinhoColumn vc = field.getAnnotation(VadinhoColumn.class);
            String name = (vc.label().isEmpty()) ? field.getName() : vc.label();
            container
                    .addContainerProperty(name, field.getType(), vc.defaults());
        }
    }

    protected void configuraDados() {
        /*
         * for(T entity: findAll(offset, limit)) { Item it =
         * container.addItem(entity.getId()); it.addItemProperty(id, property) }
         */

    }

    protected void configuraColunaGerada() {
    }

    protected void configuraInterface() {

    }
}
