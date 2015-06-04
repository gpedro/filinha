package net.gpedro.faculdade.filinha.client;

import net.gpedro.faculdade.filinha.client.views.SelectView;
import net.gpedro.faculdade.filinha.core.misc.Navigator;

import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class AlunoSenhaView extends VerticalLayout {

	private Navigator nav;
	private VerticalLayout content;

	public AlunoSenhaView() {

		content = new VerticalLayout();
		nav = new Navigator(UI.getCurrent(), content);

		addComponent(content);

		configuraNavigator();
	}

	private void configuraNavigator() {
		nav.addView("", new SelectView());
		/*
		 * nav.addView("search-aluno", ); nav.addView("show-courses", );
		 * nav.addView("add-agendamento", ); nav.addView("emitir-senha", );
		 */
	}

	public Command navigateTo(final String route) {
		return new Command() {

			@Override
			public void menuSelected(MenuItem selectedItem) {
				nav.navigateTo(route);
			}
		};
	}

}
