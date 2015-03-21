package net.gpedro.faculdade.filinha.core.converter;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import com.vaadin.data.util.converter.Converter;

@SuppressWarnings("serial")
public class StringArrayToStringConverter implements Converter<String, String[]>{
    
    private final String separator = ", ";

    @Override
    public String[] convertToModel(String value,
            Class<? extends String[]> targetType, Locale locale)
            throws com.vaadin.data.util.converter.Converter.ConversionException {
        return StringUtils.split(separator);
    }

    @Override
    public String convertToPresentation(String[] value,
            Class<? extends String> targetType, Locale locale)
            throws com.vaadin.data.util.converter.Converter.ConversionException {
        return StringUtils.join(value, separator);
    }

    @Override
    public Class<String[]> getModelType() {
        return String[].class;
    }

    @Override
    public Class<String> getPresentationType() {
        return String.class;
    }
    
}
