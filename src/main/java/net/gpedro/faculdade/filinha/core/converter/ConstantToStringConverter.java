package net.gpedro.faculdade.filinha.core.converter;

import java.util.Locale;

import net.gpedro.faculdade.filinha.core.abstracts.AbstractConstant;

import com.vaadin.data.util.converter.Converter;

public class ConstantToStringConverter implements
        Converter<String, AbstractConstant> {

    private static final long serialVersionUID = 1L;

    @Override
    public AbstractConstant convertToModel(String value,
            Class<? extends AbstractConstant> targetType, Locale locale)
            throws com.vaadin.data.util.converter.Converter.ConversionException {
        try {
            return targetType.newInstance().findByDescription(value);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new ConversionException(e.getMessage());
        }

    }

    @Override
    public String convertToPresentation(AbstractConstant value,
            Class<? extends String> targetType, Locale locale)
            throws com.vaadin.data.util.converter.Converter.ConversionException {
        return value.getDescription();
    }

    @Override
    public Class<AbstractConstant> getModelType() {
        return AbstractConstant.class;
    }

    @Override
    public Class<String> getPresentationType() {
        return String.class;
    }
}
