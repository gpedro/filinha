package net.gpedro.faculdade.filinha.core.components.input;

import lombok.NoArgsConstructor;

import com.vaadin.ui.PasswordField;

@NoArgsConstructor
public class InputPassword extends PasswordField {

    private static final long serialVersionUID = 1L;

    public InputPassword(String label) {
	super(label);
    }

    @Override
    public void setRequired(boolean required) {
	super.setRequired(required);
	if (required) {
	    setRequiredError("Este campo é obrigatório");
	}
    }
}
