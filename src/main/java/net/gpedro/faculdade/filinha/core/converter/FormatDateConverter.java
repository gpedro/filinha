package net.gpedro.faculdade.filinha.core.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.vaadin.data.util.converter.Converter;

@SuppressWarnings("serial")
public class FormatDateConverter implements Converter<String, Date> {

	private String pattern = "dd/MM/YYYY";
	private SimpleDateFormat sdf;

	public FormatDateConverter(String pattern) {
		if (pattern != null && !pattern.isEmpty()) {
			this.pattern = pattern;
		}

		sdf = new SimpleDateFormat(this.pattern);
	}

	@Override
	public Date convertToModel(String value, Class<? extends Date> targetType,
			Locale locale)
			throws com.vaadin.data.util.converter.Converter.ConversionException {
		try {
			return sdf.parse(value);
		} catch (ParseException e) {
			throw new ConversionException(e.getMessage());
		}
	}

	@Override
	public String convertToPresentation(Date value,
			Class<? extends String> targetType, Locale locale)
			throws com.vaadin.data.util.converter.Converter.ConversionException {
		return sdf.format(value);
	}

	@Override
	public Class<Date> getModelType() {
		return Date.class;
	}

	@Override
	public Class<String> getPresentationType() {
		return String.class;
	}

}
