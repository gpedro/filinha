package net.gpedro.faculdade.filinha.core.misc;

import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class Navigator extends com.vaadin.navigator.Navigator {

	public Navigator(UI ui, ComponentContainer container) {
		super(ui, container);
	}

	@Override
	public void navigateTo(String navigationState) {
		try {
			super.navigateTo(navigationState);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			navigateTo("page-not-found");
		}
	}
}
