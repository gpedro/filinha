package net.gpedro.faculdade.filinha.core.abstracts;

import net.gpedro.faculdade.filinha.core.container.MorphiaContainer;

import org.mongodb.morphia.query.Query;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

public abstract class AbstractView<T extends AbstractModel> extends
        VerticalLayout implements View {

    private static final long serialVersionUID = 1L;

    private Class<T> objClass;
    protected AbstractController<T> controller;
    private MorphiaContainer<T> container;
    protected Query<T> query;
    private T entity;

    public AbstractView(Class<T> objClass) {
        this.objClass = objClass;
        setSpacing(true);

    }

    protected void configuraContainer() {
        if (controller == null) { throw new NullPointerException(
                "O controller não foi iniciado ou é nulo"); }

        container = new MorphiaContainer<T>(objClass);
        container.setController(controller);
        container.build();
    }

    protected void configuraDados() {
        if(query == null) {
            query = controller.find();
        }
        
        entity = query.get();
    }

    protected void configuraInterface() {
        /*VerticalLayout form = new VerticalLayout();

        Class<? extends AbstractModel> entityClass = entity.getClass();
        for (Field field : VadinhoReflect.getVadinhoViewFields(objClass)) {
            Field attr;
            try {
                VadinhoView vv = field.getAnnotation(VadinhoView.class);
                if (vv != null) {
                    attr = entityClass.getDeclaredField(field.getName());
                    Object value = attr.get(entity);

                    Label labelValue = new Label();
                    labelValue.setData(value);

                    form.addComponent(new Label(
                            vv.title().isEmpty() ? StringUtils.capitalize(field
                                    .getName()) : vv.title()));
                    form.addComponent(labelValue);
                }
            } catch (NoSuchFieldException | SecurityException
                    | IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        
        addComponent(form);
        */
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
