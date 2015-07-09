package net.gpedro.faculdade.filinha.core.converter;

import java.lang.reflect.Field;
import java.util.Date;

import net.gpedro.faculdade.filinha.core.abstracts.AbstractConstant;
import net.gpedro.faculdade.filinha.core.annotations.VadinhoColumn;

import org.bson.types.ObjectId;

import com.vaadin.ui.AbstractField;
import com.vaadin.ui.Table;

public class TableConverter {

    /**
     * Define Converters para um componente
     * 
     * @param component
     *            Componente
     * @param vc
     *            Anotação
     * @param field
     *            Campo Abstrato
     */
    public static void setConverter(AbstractField<String> component,
	    VadinhoColumn vc, Field field) {

	if (field.getType() == ObjectId.class) {
	    component.setConverter(new ObjectIdToStringConverter());
	}

	if (field.getType() == String[].class) {
	    component.setConverter(new StringArrayToStringConverter());
	}

	if (field.getType() == Boolean.class) {
	    component.setConverter(new BooleanToStringConverter(vc.truth(), vc
		    .falsey()));
	}

	if (field.getType() == Date.class) {
	    component.setConverter(new FormatDateConverter(vc.dateFormat()));
	}

	if (field.getType().isEnum()) {

	    Class<?>[] interfaces = field.getType().getInterfaces();
	    if (interfaces.length > 0
		    && interfaces[0] == AbstractConstant.class) {
		component.setConverter(new ConstantToStringConverter());
	    }

	}

    }

    /**
     * Define Converters para uma propriedade dentro de uma tabela
     * 
     * @param component
     *            Tabela
     * @param vc
     *            Anotação
     * @param field
     *            Campo Abstrato
     * @param propertyId
     *            Nome da propriedade
     */
    public static void setConverter(Table component, VadinhoColumn vc,
	    Field field, String propertyId) {

	if (field.getType() == ObjectId.class) {
	    component.setConverter(propertyId, new ObjectIdToStringConverter());
	}

	if (field.getType() == String[].class) {
	    component.setConverter(propertyId,
		    new StringArrayToStringConverter());
	}

	if (field.getType() == Boolean.class) {
	    component.setConverter(propertyId,
		    new BooleanToStringConverter(vc.truth(), vc.falsey()));
	}

	if (field.getType() == Date.class) {
	    component.setConverter(propertyId,
		    new FormatDateConverter(vc.dateFormat()));
	}

	if (field.getType().isEnum()) {

	    Class<?>[] interfaces = field.getType().getInterfaces();
	    if (interfaces.length > 0
		    && interfaces[0] == AbstractConstant.class) {
		component.setConverter(propertyId,
			new ConstantToStringConverter());
	    }

	}

    }
}
