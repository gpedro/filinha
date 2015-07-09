package net.gpedro.faculdade.filinha.core.converter;

import java.util.Locale;

import com.vaadin.data.util.converter.Converter;

@SuppressWarnings("serial")
public class BooleanToStringConverter implements Converter<String, Boolean> {

    private String TRUE = "Sim";
    private String FALSE = "Não";

    public BooleanToStringConverter(String truth, String falsey) {
	this.TRUE = truth;
	this.FALSE = falsey;
    }

    @Override
    public Boolean convertToModel(String value,
	    Class<? extends Boolean> targetType, Locale locale)
	    throws com.vaadin.data.util.converter.Converter.ConversionException {
	return value == TRUE;
    }

    @Override
    public String convertToPresentation(Boolean value,
	    Class<? extends String> targetType, Locale locale)
	    throws com.vaadin.data.util.converter.Converter.ConversionException {
	// TODO Auto-generated method stub
	return (value) ? TRUE : FALSE;
    }

    @Override
    public Class<Boolean> getModelType() {
	return Boolean.class;
    }

    @Override
    public Class<String> getPresentationType() {
	return String.class;
    }

}
