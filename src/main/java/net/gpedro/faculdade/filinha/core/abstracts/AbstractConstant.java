package net.gpedro.faculdade.filinha.core.abstracts;

public interface AbstractConstant {

    String name        = "";
    String description = "";

    public String getDescription();

    public AbstractConstant findByDescription(String description);
}
