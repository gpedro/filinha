package net.gpedro.faculdade.filinha.core.container;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import net.gpedro.faculdade.filinha.core.abstracts.AbstractController;
import net.gpedro.faculdade.filinha.core.abstracts.AbstractModel;

import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;

import com.vaadin.data.Container;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.ui.Label;

@SuppressWarnings("serial")
public class MorphiaContainer<T extends AbstractModel> extends
	BeanContainer<ObjectId, T> implements Container.Ordered,
	Container.Sortable {

    @Setter
    private AbstractController<T> controller;

    @Setter
    public Query<T> query;

    @Setter
    @Getter
    public int rowsPerPage = 2;

    @Getter
    public int currentPage = 1;

    @Getter
    public int totalPages;

    @Getter
    public int totalRows = -1;

    @Setter
    public Label label;

    private int offset = 0;

    public MorphiaContainer(Class<T> objClass) {
	super(objClass);

	this.setBeanIdResolver(new BeanIdResolver<ObjectId, T>() {

	    @Override
	    public ObjectId getIdForBean(T bean) {
		return bean.getId();
	    }
	});
    }

    public void refreshPagination() {

	if (label == null) {
	    label = new Label();
	}

	label.setValue("Página " + getCurrentPage() + " de " + getTotalPages());

    }

    public void build() {
	if (query == null) {
	    query = controller.find();
	}

	if (totalRows == -1) {
	    totalRows = (query.asList().size());
	}

	totalPages = (int) Math.ceil(totalRows / rowsPerPage);
	totalPages = (totalPages == 0) ? 1 : totalPages;
	if (totalPages > 1) {
	    totalPages++;
	}

	offset = rowsPerPage * (currentPage - 1);

	query.limit(rowsPerPage).offset(offset);
	removeAllItems();
	this.addAll(query.asList());
	refreshPagination();
    }

    @Override
    protected void sortContainer(Object[] propertyId, boolean[] ascending) {
	int index = 0;
	List<String> order = new ArrayList<String>();
	for (Object property : propertyId) {
	    order.add(((!ascending[index]) ? "-" : "") + property);
	    index++;
	}

	query.order(StringUtils.join(order, ","));
	removeAllItems();
	goToPage(currentPage);
    }

    public void goToPage(int page) {
	currentPage = page;

	build();
    }

    public boolean nextPage() {
	int nextPage = currentPage + 1;
	if (nextPage <= totalPages) {
	    goToPage(nextPage);
	    return true;
	}
	return false;
    }

    public boolean previousPage() {
	int previousPage = currentPage - 1;
	if (previousPage > 0) {
	    goToPage(previousPage);
	    return true;
	}

	return false;
    }
}
