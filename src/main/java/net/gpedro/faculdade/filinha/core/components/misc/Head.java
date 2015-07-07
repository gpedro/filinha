package net.gpedro.faculdade.filinha.core.components.misc;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;

public enum Head {

	H1, H2, H3, H4, H5, H6, HR;
	
	private Label toComponent() {
		return new Label("<hr />", ContentMode.HTML);
	}
	
	public Label toComponent(String value) {
		if (this == HR) {
			return this.toComponent();
		}
		
		if (value == null) return null;
		
		String start = "<" + this.name().toLowerCase() + ">";
		String end = "</" + this.name().toLowerCase() + ">";
		return new Label(start + value + end, ContentMode.HTML);
	}
	
}
