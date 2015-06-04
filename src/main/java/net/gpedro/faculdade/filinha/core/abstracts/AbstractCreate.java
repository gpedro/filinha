package net.gpedro.faculdade.filinha.core.abstracts;

import java.lang.reflect.Field;
import java.util.List;

import net.gpedro.faculdade.filinha.core.annotations.VadinhoColumn;
import net.gpedro.faculdade.filinha.core.components.input.InputText;
import net.gpedro.faculdade.filinha.core.converter.ListToStringConverter;
import net.gpedro.faculdade.filinha.core.converter.ObjectIdToStringConverter;
import net.gpedro.faculdade.filinha.core.converter.StringArrayToStringConverter;
import net.gpedro.faculdade.filinha.core.misc.VadinhoReflect;

import org.bson.types.ObjectId;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public abstract class AbstractCreate<T extends AbstractModel> extends
		VerticalLayout implements View {

	private Class<T> objClass;
	protected BeanFieldGroup<T> bean;
	protected AbstractController<T> controller;

	public AbstractCreate(Class<T> objClass) {
		this.objClass = objClass;
		setSpacing(true);
		bean = new BeanFieldGroup<T>(objClass);
	}

	private void configuraDados() {
		if (controller == null) {
			throw new NullPointerException(
					"O controller não foi iniciado ou é nulo");
		}
	}

	protected void configuraInterface() {
		FormLayout form = new FormLayout();
		form.setSpacing(true);
		form.setMargin(true);

		for (Field field : VadinhoReflect.getVadinhoFields(objClass)) {
			try {
				VadinhoColumn vc = field.getAnnotation(VadinhoColumn.class);

				if (!vc.create()) {
					continue;
				}

				if (field.getType().isEnum()) {
					ComboBox cb = new ComboBox(
							VadinhoReflect.getParsedLabel(field));
					cb.setSizeFull();
					cb.addItems(field.getType().getEnumConstants());
					/*
					 * cb.setItemCaptionMode(ItemCaptionMode.PROPERTY);
					 * cb.setItemCaptionPropertyId("name");
					 */
					bean.bind(cb, field.getName());

					addComponent(cb);
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

				InputText tf = new InputText(
						VadinhoReflect.getParsedLabel(field));
				if (field.getType() == ObjectId.class) {
					tf.setConverter(new ObjectIdToStringConverter());
				}

				if (field.getType() == List.class) {
					tf.setConverter(new ListToStringConverter());
				}

				if (field.getType() == String[].class) {
					tf.setConverter(new StringArrayToStringConverter());
				}

				bean.bind(tf, field.getName());
				tf.setWidth(100, Unit.PERCENTAGE);
				addComponent(tf);
			} catch (SecurityException | IllegalArgumentException e) {
				e.printStackTrace();
			}
		}

		form.setSizeFull();
		addComponent(form);
	}

	public void build() {
		configuraDados();
		configuraInterface();
	}
}
