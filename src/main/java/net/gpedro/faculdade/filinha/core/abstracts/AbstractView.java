package net.gpedro.faculdade.filinha.core.abstracts;

import java.lang.reflect.Field;

import net.gpedro.faculdade.filinha.core.annotations.VadinhoColumn;
import net.gpedro.faculdade.filinha.core.components.input.InputText;
import net.gpedro.faculdade.filinha.core.container.MorphiaContainer;
import net.gpedro.faculdade.filinha.core.converter.ObjectIdToStringConverter;
import net.gpedro.faculdade.filinha.core.converter.StringArrayToStringConverter;
import net.gpedro.faculdade.filinha.core.misc.VadinhoReflect;

import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.VerticalLayout;

public abstract class AbstractView<T extends AbstractModel> extends
        VerticalLayout implements View {

    private static final long serialVersionUID = 1L;

    private Class<T> objClass;
    protected AbstractController<T> controller;
    private MorphiaContainer<T> container;
    protected Query<T> query;
    private T entity;
    protected BeanFieldGroup<T> bean;

    public AbstractView(Class<T> objClass) {
        this.objClass = objClass;
        setSpacing(true);
        bean = new BeanFieldGroup<T>(objClass);
    }

    protected void configuraContainer() {
        if (controller == null) { throw new NullPointerException(
                "O controller não foi iniciado ou é nulo"); }

        container = new MorphiaContainer<T>(objClass);
        container.setController(controller);
        container.build();
    }

    protected void configuraDados() {
        if (query == null) {
            query = controller.find();
        }

        entity = query.get();
        bean.setItemDataSource(entity);
    }

    protected void configuraInterface() {
        VerticalLayout form = new VerticalLayout();

        for (Field field : VadinhoReflect.getVadinhoFields(objClass)) {
            try {
                VadinhoColumn vc = field.getAnnotation(VadinhoColumn.class);
                
                // Não mostra o campo se o view = false na anotação do vadinho
                if(!vc.view()) {
                    continue;
                }
                
                if (field.getType() == Boolean.class) {
                    BeanItemContainer<Boolean> bc = new BeanItemContainer<Boolean>(Boolean.class);
                    bc.addBean(true);
                    bc.addBean(false);
                    
                    ComboBox cb = new ComboBox(VadinhoReflect.getParsedLabel(field));
                    cb.setItemCaption(true, vc.truth());
                    cb.setItemCaption(false, vc.falsey());
                    cb.setContainerDataSource(bc);
                    bean.bind(cb, field.getName());
                    addComponent(cb);
                    return;
                }

                InputText tf = new InputText(
                        VadinhoReflect.getParsedLabel(field));
                if (field.getType() == ObjectId.class) {
                    tf.setConverter(new ObjectIdToStringConverter());
                }

                if (field.getType() == String[].class) {
                    tf.setConverter(new StringArrayToStringConverter());
                }

                bean.bind(tf, field.getName());
                addComponent(tf);
            } catch (SecurityException | IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        addComponent(form);
    }

    public void build() {
        configuraContainer();
        configuraDados();
        configuraInterface();
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }
}
