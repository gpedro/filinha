package net.gpedro.faculdade.filinha.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface VadinhoColumn {
    /**
     * Flag para definir se o campo é obrigatório
     */
    boolean required() default false;

    /**
     * Label da Coluna
     */
    String label() default "";

    /**
     * Valor padrão ao invés de null
     */
    String defaults() default "";

    /**
     * Tamanho da Coluna
     */
    int width() default -1;
}
