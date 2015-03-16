package net.gpedro.faculdade.filinha.core.misc;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import net.gpedro.faculdade.filinha.core.abstracts.AbstractModel;
import net.gpedro.faculdade.filinha.core.annotations.VadinhoColumn;

import org.apache.commons.lang3.StringUtils;

public class VadinhoReflect<T extends AbstractModel> {

    private Class<T> objClass;

    @Getter
    private List<Field> visibleFields;

    @Getter
    private List<String> vadinhoHeaders;

    @Getter
    private List<String> vadinhoColumns;

    public VadinhoReflect(Class<T> objClass) {
        this.objClass = objClass;
        visibleFields = new ArrayList<Field>();
        vadinhoColumns = new ArrayList<String>();
        vadinhoHeaders = new ArrayList<String>();

        getMetaData();
    }

    @SuppressWarnings("rawtypes")
    public Field[] getFieldByClass(Class classe) {
        List<Field> fieldsClass = new ArrayList<Field>();
        if (classe.getSuperclass() != null) {
            fieldsClass.addAll(Arrays.asList(getFieldByClass(classe
                    .getSuperclass())));
        }
        fieldsClass.addAll(Arrays.asList(classe.getDeclaredFields()));

        return fieldsClass.toArray(new Field[] {});
    }

    public void getMetaData() {
        for(Field field: getFieldByClass(objClass)){
            VadinhoColumn annotation = field.getAnnotation(VadinhoColumn.class);
            
            if (annotation != null) {
                String label = (annotation.label().isEmpty()) ? StringUtils
                        .capitalize(field.getName()) : annotation.label();
                
                visibleFields.add(field);
                vadinhoColumns.add(field.getName());
                vadinhoHeaders.add(label);
            }
        }
    }
}
