package net.gpedro.faculdade.filinha.core.abstracts;

import net.gpedro.faculdade.filinha.core.components.button.Button;
import net.gpedro.faculdade.filinha.core.container.MorphiaContainer;
import net.gpedro.faculdade.filinha.core.misc.VadinhoReflect;

import org.mongodb.morphia.query.Query;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public abstract class AbstractViewList<T extends AbstractModel> extends
        VerticalLayout {

    private static final long serialVersionUID = 1L;

    private Class<T> objClass;
    private Table tabela;
    protected AbstractController<T> controller;
    private MorphiaContainer<T> container;
    protected Query<T> query;

    private Label pageLabel;
    
    public AbstractViewList(Class<T> objClass) {
        this.objClass = objClass;
        pageLabel = new Label("Carregando ...");
        
        tabela = new Table("Listar " + objClass.getSimpleName());
    }

    public void build() {
        configuraTabela();
        configuraContainer();
        configuraDados();
        configuraInterface();
    }

    protected void configuraTabela() {
        tabela.setImmediate(true);
        tabela.setWidth(100, Unit.PERCENTAGE);
        tabela.setHeightUndefined();
    }

    protected void configuraContainer() {
        if (controller == null) { throw new NullPointerException(
                "O controller não foi iniciado ou é nulo"); }

        container = new MorphiaContainer<T>(objClass);
        container.setLabel(pageLabel);
        container.setController(controller);
        container.build();
    }
    
    protected void configuraDados() {
        tabela.setContainerDataSource(container);
        
        configuraColunaDefault();
        configuraColunaGerada();
    }

    protected void configuraColunaDefault() {
        VadinhoReflect<T> vr = new VadinhoReflect<T>(objClass);
        tabela.setVisibleColumns(vr.getVadinhoColumns().toArray());
        tabela.setColumnHeaders(vr.getVadinhoHeaders().toArray(new String[] {}));
    }

    protected void configuraColunaGerada() {
    }

    @SuppressWarnings("serial")
    protected void configuraInterface() {
        addComponent(tabela);

        Button pagePrevious = new Button("<");
        Button pageNext     = new Button(">");
        
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
        pagination.addComponent(pagePrevious);
        pagination.addComponent(pageLabel);
        pagination.addComponent(pageNext);
        
        addComponent(pagination);
    }
}
