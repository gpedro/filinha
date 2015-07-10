package net.gpedro.faculdade.filinha.core.abstracts;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import net.gpedro.faculdade.filinha.core.annotations.VadinhoColumn;
import net.gpedro.faculdade.filinha.core.components.input.InputText;
import net.gpedro.faculdade.filinha.core.container.MorphiaContainer;
import net.gpedro.faculdade.filinha.core.converter.TableConverter;
import net.gpedro.faculdade.filinha.core.misc.VadinhoReflect;

import org.mongodb.morphia.query.Query;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.VerticalLayout;

public abstract class AbstractView<T extends AbstractModel> extends
        VerticalLayout implements View {

    private static final long       serialVersionUID = 1L;

    private Class<T>                objClass;
    protected AbstractController<T> controller;
    private MorphiaContainer<T>     container;
    protected Query<T>              query;
    private T                       entity;
    protected BeanFieldGroup<T>     bean;

    public AbstractView(Class<T> objClass) {
        this.objClass = objClass;
        setSpacing(true);
        bean = new BeanFieldGroup<T>(objClass);
    }

    protected void configuraContainer() {
        if (bean.getItemDataSource() != null)
            return;

        if (controller == null) {
            throw new NullPointerException(
                    "O controller não foi iniciado ou é nulo");
        }

        container = new MorphiaContainer<T>(objClass);
        container.setController(controller);
        container.build();
    }

    protected void configuraDados() {
        if (bean.getItemDataSource() != null)
            return;

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
                if (!vc.view()) {
                    continue;
                }

                if (field.getType() == Boolean.class) {
                    BeanItemContainer<Boolean> bc = new BeanItemContainer<Boolean>(
                            Boolean.class);
                    bc.addBean(true);
                    bc.addBean(false);

                    ComboBox cb = new ComboBox(
                            VadinhoReflect.getParsedLabel(field));
                    cb.setSizeFull();
                    cb.setItemCaption(true, vc.truth());
                    cb.setItemCaption(false, vc.falsey());
                    cb.setContainerDataSource(bc);
                    bean.bind(cb, field.getName());
                    addComponent(cb);
                    continue;
                }

                if (field.getType() == List.class) {
                    // System.out.println(1);

                    /*
                     * Table tbl = new
                     * Table(VadinhoReflect.getParsedLabel(field), tc);
                     * bean.bind(tbl, field.getName()); return;
                     */
                }

                if (field.getType().isEnum()) {
                    if (field.getType().getInterfaces().length > 0) {
                        for (Class<?> interfaces : field.getType()
                                .getInterfaces()) {
                            if (interfaces == AbstractConstant.class) {
                                BeanItemContainer<AbstractConstant> bc = new BeanItemContainer<AbstractConstant>(
                                        AbstractConstant.class);
                                Method valuesMethod = field.getType()
                                        .getDeclaredMethod("values", null);
                                AbstractConstant[] values = (AbstractConstant[]) valuesMethod
                                        .invoke(null, null);
                                bc.addAll(Arrays.asList(values));

                                ComboBox cb = new ComboBox(
                                        VadinhoReflect.getParsedLabel(field));
                                cb.setSizeFull();
                                cb.setItemCaptionPropertyId("description");
                                cb.setContainerDataSource(bc);
                                bean.bind(cb, field.getName());

                                addComponent(cb);
                                break;
                            }
                        }

                        continue;
                    }
                }

                InputText tf = new InputText(
                        VadinhoReflect.getParsedLabel(field));

                TableConverter.setConverter(tf, vc, field);

                bean.bind(tf, field.getName());

                if (vc.readOnly()) {
                    tf.setEnabled(false);
                    tf.setDescription("Campo desabilitado.");
                }

                tf.setWidth(100, Unit.PERCENTAGE);
                addComponent(tf);
            } catch (SecurityException | IllegalArgumentException
                    | NoSuchMethodException | IllegalAccessException
                    | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        form.setSizeFull();
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
