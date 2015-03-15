package net.gpedro.faculdade.filinha.core.misc;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import net.gpedro.faculdade.filinha.core.abstracts.AbstractModel;
import net.gpedro.faculdade.filinha.core.annotations.VadinhoColumn;

public class VadinhoReflect<T extends AbstractModel> {

    private Class<T> objClass;

    @Getter
    private List<Field> fields;

    @Getter
    private List<Field> visibleFields;

    public VadinhoReflect(Class<T> objClass) {
        this.objClass = objClass;
        fields = new ArrayList<Field>();

        getMetaData();
    }

    public void getMetaData() {
        Field[] attributes = objClass.getDeclaredFields();
        for (Field field : attributes) {
            VadinhoColumn annotation = field.getAnnotation(VadinhoColumn.class);
            fields.add(field);
            if (annotation != null) {
                visibleFields.add(field);
            }
        }
    }

}
