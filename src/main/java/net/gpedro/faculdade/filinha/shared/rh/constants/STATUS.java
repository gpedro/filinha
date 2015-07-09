package net.gpedro.faculdade.filinha.shared.rh.constants;

import org.vaadin.teemu.VaadinIcons;

import lombok.Getter;
import net.gpedro.faculdade.filinha.core.abstracts.AbstractConstant;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;

public enum STATUS implements AbstractConstant {
    DISPONIVEL("Disponível"), EM_ATENDIMENTO("Em Atendimento"), AUSENTE(
	    "Ausente"), INDISPONIVEL("Indisponível");

    @Getter
    private String description;

    STATUS(String description) {
	this.description = description;
    }

    public boolean isDisponivel() {
	return this == STATUS.DISPONIVEL;
    }

    public boolean isEmAtendimento() {
	return this == STATUS.EM_ATENDIMENTO;
    }

    public boolean isAusente() {
	return this == STATUS.AUSENTE;
    }

    public boolean isIndisponivel() {
	return this == STATUS.INDISPONIVEL;
    }

    public String getIcon() {
	return getIcon(false);
    }

    public String getIcon(boolean withDescription) {
	String color = null;
	switch (this) {
	case DISPONIVEL:
	    color = "#2ecc71";
	    break;
	case EM_ATENDIMENTO:
	    color = "#e74c3c";
	    break;
	case AUSENTE:
	    color = "#f1c40f";
	    break;
	case INDISPONIVEL:
	    color = "#bdc3c7";
	    break;
	}

	return "<div style=\"color: " + color + "\">"
		+ VaadinIcons.CIRCLE.getHtml() + "&nbsp;&nbsp;"
		+ ((withDescription) ? getDescription() : "") + "</div>";
    }

    public Label getComponent() {
	return getComponent(true);
    }

    public Label getComponent(boolean withDescription) {
	return new Label(getIcon(withDescription), ContentMode.HTML);
    }

    @Override
    public AbstractConstant findByDescription(String description) {
	for (AbstractConstant value : values()) {
	    if (value.getDescription() == description) {
		return value;
	    }
	}

	return null;
    }

}
