package net.gpedro.faculdade.filinha.core.components.input;

import net.gpedro.faculdade.filinha.core.validators.CpfValidator;

import org.vaadin.addons.maskedtextfield.MaskedTextField;

@SuppressWarnings("serial")
public class InputCpf extends MaskedTextField {

    public InputCpf() {
	this(null, true);
    }

    public InputCpf(String caption) {
	this(caption, true);
    }

    public InputCpf(String caption, boolean validate) {
	setCaption(caption);
	setMask("###.###.###-##");

	if (validate) {
	    addValidator(new CpfValidator());
	}
    }

}
