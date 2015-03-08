package net.gpedro.faculdade.filinha.core.components.input;

import lombok.NoArgsConstructor;

import com.vaadin.ui.TextField;

@NoArgsConstructor
public class InputText extends TextField {

    private static final long serialVersionUID = 1L;

    public InputText(String label) {
        super(label);

        setNullRepresentation("");
    }

    @Override
    public void setRequired(boolean required) {
        super.setRequired(required);
        if (required) {
            setRequiredError("Este campo é obrigatório");
        }
    }

}
