package net.gpedro.faculdade.filinha.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface VadinhoList {

    /**
     * Titulo
     */
    String title() default "";

    /**
     * Sentido da Ordenação
     */
    String orderDirection() default "DESC";

    /**
     * Nome da Coluna para Ordenação
     */
    String orderBy() default "id";

    /**
     * Apenas modo visualização
     */
    boolean readOnly() default false;
}
