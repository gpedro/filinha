package net.gpedro.faculdade.filinha.core.converter;

import java.util.Locale;

import org.bson.types.ObjectId;

import com.vaadin.data.util.converter.Converter;

@SuppressWarnings("serial")
public class ObjectIdToStringConverter implements Converter<String, ObjectId> {

	@Override
	public ObjectId convertToModel(String value,
			Class<? extends ObjectId> targetType, Locale locale)
			throws com.vaadin.data.util.converter.Converter.ConversionException {
		return new ObjectId(value);
	}

	@Override
	public String convertToPresentation(ObjectId value,
			Class<? extends String> targetType, Locale locale)
			throws com.vaadin.data.util.converter.Converter.ConversionException {
		return value.toHexString();
	}

	@Override
	public Class<ObjectId> getModelType() {
		return ObjectId.class;
	}

	@Override
	public Class<String> getPresentationType() {
		return String.class;
	}
}
