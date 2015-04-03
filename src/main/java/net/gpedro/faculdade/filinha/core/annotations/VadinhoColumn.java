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

    /**
     * Se o campo deverá aparecer no tela de criação
     */
    boolean create() default true;

    /**
     * Se o campo deverá aparecer na tela de edição
     */
    boolean edit() default true;

    /**
     * Se o campo deverá aparecer na tela de visualização
     */
    boolean view() default true;

    /**
     * Se o campo deverá aparecer na tela de listagem
     */
    boolean list() default true;

    /**
     * Apenas visualização
     */
    boolean readOnly() default false;
    
    /**
     * Formato da Data
     */
    String dateFormat() default "";

    /**
     * Valor para boolean true
     */
    String truth() default "Sim";

    /**
     * Valor para boolean false
     */
    String falsey() default "Não";

}
