package net.gpedro.faculdade.filinha.core.converter;

import java.util.Locale;

import com.vaadin.data.util.converter.Converter;

@SuppressWarnings("serial")
public class MaskConverter implements Converter<String, Object> {

    private String mask;
    
    public MaskConverter(String mask) {
        this.mask = mask;
    }
    
    @Override
    public Object convertToModel(String value,
            Class<? extends Object> targetType, Locale locale)
            throws com.vaadin.data.util.converter.Converter.ConversionException {
        return null;
    }

    @Override
    public String convertToPresentation(Object value,
            Class<? extends String> targetType, Locale locale)
            throws com.vaadin.data.util.converter.Converter.ConversionException {
        return null;
    }

    @Override
    public Class<Object> getModelType() {
        return Object.class;
    }

    @Override
    public Class<String> getPresentationType() {
        return String.class;
    }

}
