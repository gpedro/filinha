package net.gpedro.faculdade.filinha.core.converter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import com.vaadin.data.util.converter.Converter;

@SuppressWarnings("serial")
public class ListToStringConverter implements Converter<String, List<?>> {

    private final String separator = ", ";

    @Override
    public List<?> convertToModel(String value,
	    Class<? extends List<?>> targetType, Locale locale)
	    throws com.vaadin.data.util.converter.Converter.ConversionException {
	List<Object> list = new ArrayList<Object>();
	Collections.addAll(list, value.split(separator));

	return list;
    }

    @Override
    public String convertToPresentation(List<?> value,
	    Class<? extends String> targetType, Locale locale)
	    throws com.vaadin.data.util.converter.Converter.ConversionException {
	return StringUtils.join(value, separator);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<List<?>> getModelType() {
	List<Object> objList = new ArrayList<Object>();
	return (Class<List<?>>) objList.getClass();
    }

    @Override
    public Class<String> getPresentationType() {
	return String.class;
    }

}
