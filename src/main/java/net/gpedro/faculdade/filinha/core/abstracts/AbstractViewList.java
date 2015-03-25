package net.gpedro.faculdade.filinha.core.abstracts;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import net.gpedro.faculdade.filinha.core.annotations.VadinhoColumn;
import net.gpedro.faculdade.filinha.core.components.button.Button;
import net.gpedro.faculdade.filinha.core.container.MorphiaContainer;
import net.gpedro.faculdade.filinha.core.converter.BooleanToStringConverter;
import net.gpedro.faculdade.filinha.core.converter.FormatDateConverter;
import net.gpedro.faculdade.filinha.core.converter.StringArrayToStringConverter;
import net.gpedro.faculdade.filinha.core.misc.VadinhoReflect;

import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public abstract class AbstractViewList<T extends AbstractModel> extends
        VerticalLayout implements View {

    private static final long serialVersionUID = 1L;

    private Class<T> objClass;
    private Table tabela;
    protected AbstractController<T> controller;
    private MorphiaContainer<T> container;
    protected Query<T> query;

    private int rowsPerPage = 5;
    private Label pageLabel;

    public AbstractViewList(Class<T> objClass) {
        this.objClass = objClass;
        pageLabel = new Label("Carregando ...");
        setSpacing(true);
        tabela = new Table("Listar " + objClass.getSimpleName());
    }

    public void build() {
        configuraTabela();
        configuraContainer();
        configuraDados();
        configuraInterface();
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

    protected void configuraTabela() {
        tabela.setImmediate(true);
        tabela.setWidth(100, Unit.PERCENTAGE);
        tabela.setPageLength(rowsPerPage);
    }

    protected void configuraContainer() {
        if (controller == null) { throw new NullPointerException(
                "O controller não foi iniciado ou é nulo"); }

        container = new MorphiaContainer<T>(objClass);
        container.setRowsPerPage(rowsPerPage);
        container.setLabel(pageLabel);
        container.setController(controller);
        container.build();
    }

    protected void configuraDados() {
        tabela.setContainerDataSource(container);

        try {
            configuraColunaDefault();
            configuraColunaGerada();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected void configuraColunaDefault() throws IllegalAccessException {
        List<String> vadinhoHeaders = VadinhoReflect
                .getVadinhoColumnsLabel(objClass);
        List<String> vadinhoColumns = VadinhoReflect
                .getVadinhoColumnsName(objClass);
        List<Field> vadinhoFields = VadinhoReflect.getVadinhoFields(objClass);

        tabela.setVisibleColumns(vadinhoColumns.toArray(new Object[] {}));
        tabela.setColumnHeaders(vadinhoHeaders.toArray(new String[] {}));

        for (int i = 0; i < vadinhoColumns.size(); i++) {
            Field field = vadinhoFields.get(i);

            VadinhoColumn vc = field.getAnnotation(VadinhoColumn.class);

            String propertyId = vadinhoColumns.get(i);

            if (field.getType().isPrimitive()
                    && field.getType() != ObjectId.class) { throw new IllegalAccessException(
                    "> " + propertyId + " não deve ser um valor primitivo"); }

            if (vc != null && vc.width() > 0) {
                tabela.setColumnWidth(vadinhoColumns.get(i), vc.width());
            }

            if (field.getType() == String[].class) {
                tabela.setConverter(propertyId,
                        new StringArrayToStringConverter());
            }

            if (field.getType() == Boolean.class) {
                tabela.setConverter(propertyId, new BooleanToStringConverter(vc.truth(), vc.falsey()));
            }

            if (field.getType() == Date.class) {
                tabela.setConverter(propertyId,
                        new FormatDateConverter(vc.dateFormat()));
            }
        }
    }

    protected void configuraColunaGerada() {
    }

    @SuppressWarnings("serial")
    protected void configuraInterface() {
        addComponent(tabela);

        Button pagePrevious = new Button("<");
        Button pageNext = new Button(">");

        pagePrevious.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                container.previousPage();
            }
        });

        pageNext.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                container.nextPage();
            }
        });

        HorizontalLayout pagination = new HorizontalLayout();
        pagination.setSpacing(true);

        pagination.addComponent(pagePrevious);
        pagination.addComponent(pageLabel);
        pagination.addComponent(pageNext);

        pagination.setComponentAlignment(pageLabel, Alignment.MIDDLE_CENTER);

        addComponent(pagination);
        setComponentAlignment(pagination, Alignment.MIDDLE_CENTER);
    }
}
