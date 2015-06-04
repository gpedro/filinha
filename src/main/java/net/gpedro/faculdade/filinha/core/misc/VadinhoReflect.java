package net.gpedro.faculdade.filinha.core.misc;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.gpedro.faculdade.filinha.core.abstracts.AbstractModel;
import net.gpedro.faculdade.filinha.core.annotations.VadinhoColumn;

import org.apache.commons.lang3.StringUtils;

public class VadinhoReflect<T extends AbstractModel> {

	public static Field[] getFieldByClass(Class<?> classe) {
		List<Field> fieldsClass = new ArrayList<Field>();
		if (classe.getSuperclass() != null) {
			fieldsClass.addAll(Arrays.asList(getFieldByClass(classe
					.getSuperclass())));
		}
		fieldsClass.addAll(Arrays.asList(classe.getDeclaredFields()));

		return fieldsClass.toArray(new Field[] {});
	}

	/**
	 * Busca atributos de uma classe @objClass onde contenha @annotation
	 * 
	 * @param objClass
	 *            Classe do Objeto
	 * @param annotation
	 *            Classe da Anotação
	 * @return
	 */
	public static List<Field> getFieldByAnnotation(Class<?> objClass,
			Class<? extends Annotation> annotation) {
		List<Field> lista = new ArrayList<Field>();
		for (Field field : getFieldByClass(objClass)) {
			if (field.isAnnotationPresent(annotation)) {
				lista.add(field);
			}
		}

		return lista;
	}

	/**
	 * Busca o nome dos atributos de uma classe @objClass onde contenha
	 * annotation
	 * 
	 * @param objClass
	 *            Classe do Objeto
	 * @param annotation
	 *            Classe da Anotação
	 * @return
	 */
	public static List<String> getFieldNameByAnnotation(Class<?> objClass,
			Class<? extends Annotation> annotation) {
		List<Field> fields = getFieldByAnnotation(objClass, annotation);
		List<String> fieldsName = new ArrayList<String>();

		for (Field field : fields) {
			fieldsName.add(field.getName());
		}

		return fieldsName;
	}

	/**
	 * Busca todos atributos de uma classe onde contenha a notação @VadinhoColumn
	 * 
	 * @param objClass
	 * @see VadinhoColumn
	 * @return
	 */
	public static List<Field> getVadinhoFields(Class<?> objClass) {
		return getFieldByAnnotation(objClass, VadinhoColumn.class);
	}

	/**
	 * Busca todos os nomes dos atributos de uma classe onde contenha a notação @VadinhoColumn
	 * 
	 * @param objClass
	 * @see VadinhoColumn
	 * @return
	 */
	public static List<String> getVadinhoColumnsName(Class<?> objClass) {
		return getFieldNameByAnnotation(objClass, VadinhoColumn.class);
	}

	public static String getParsedLabel(Field field) {
		String label = "";
		if (field != null) {
			VadinhoColumn annotation = field.getAnnotation(VadinhoColumn.class);
			if (annotation != null) {
				label = (annotation.label().isEmpty()) ? StringUtils
						.capitalize(field.getName()) : annotation.label();
			}
		}

		return label;
	}

	/**
	 * Busca a label de todos atributos de uma classe onde contenha a notação @VadinhoColumn
	 * 
	 * @param objClass
	 * @see VadinhoColumn
	 * @return
	 */
	public static List<String> getVadinhoColumnsLabel(Class<?> objClass) {
		List<String> lista = new ArrayList<String>();
		for (Field field : getVadinhoFields(objClass)) {
			lista.add(getParsedLabel(field));
		}

		return lista;
	}
}
