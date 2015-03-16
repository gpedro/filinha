package net.gpedro.faculdade.filinha.core.abstracts;

import net.gpedro.faculdade.filinha.core.components.button.Button;
import net.gpedro.faculdade.filinha.core.misc.VadinhoReflect;

import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;

import com.vaadin.data.util.AbstractBeanContainer.BeanIdResolver;
import com.vaadin.data.util.BeanContainer;
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
    private BeanContainer<ObjectId, T> container;
    protected Query<T> query;

    private Label pageLabel;
    
    private int perPage = 2;
    private long allRows = -1;
    private int page = 1;
    private int pages = 0;
    private int offset = 0;
    
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
    }

    protected void configuraContainer() {
        if (controller == null) { throw new NullPointerException(
                "O controller não foi iniciado ou é nulo"); }

        container = new BeanContainer<ObjectId, T>(objClass);
        container.setBeanIdResolver(new BeanIdResolver<ObjectId, T>() {
            private static final long serialVersionUID = 1L;

            @Override
            public ObjectId getIdForBean(T bean) {
                return bean.getId();
            }
        });
    }
    
    protected void configuraDados() {
        if(query == null) {
            query = controller.find();
        }

        if(allRows == -1) {
            allRows = query.countAll();
        }
        
        pages = (int) Math.ceil(allRows/perPage);
        offset = perPage * page;
        
        query.limit(perPage).offset(offset);
        
        container.removeAllItems();
        container.addAll(query.asList());
        tabela.setContainerDataSource(container);

        pageLabel.setValue("Página " + page + " de " + pages);
        
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
                if((page - 1) > 0) {
                    page--;
                    configuraDados();
                }
            }
        });
        
        pageNext.addClickListener(new ClickListener() {
            
            @Override
            public void buttonClick(ClickEvent event) {
                if(page + 1 <= pages) {
                    page++;
                    configuraDados();
                }
            }
        });
        
        HorizontalLayout pagination = new HorizontalLayout();
        pagination.addComponent(pagePrevious);
        pagination.addComponent(pageLabel);
        pagination.addComponent(pageNext);
        
        addComponent(pagination);
    }
}
