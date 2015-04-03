package net.gpedro.faculdade.filinha.core.layout;

import net.gpedro.faculdade.filinha.core.annotations.VadinhoMenu;
import net.gpedro.faculdade.filinha.core.misc.Navigator;
import net.gpedro.faculdade.filinha.core.pages.PageNotFound;
import net.gpedro.faculdade.filinha.modules.courses.view.CourseList;
import net.gpedro.faculdade.filinha.modules.courses.view.CourseView;
import net.gpedro.faculdade.filinha.modules.rh.view.AlunoViewList;
import net.gpedro.faculdade.filinha.modules.rh.view.CoordenadorViewList;

import com.vaadin.navigator.View;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class ApplicationLayout extends VerticalLayout {

    VerticalLayout content;
    MenuBar menu;
    Navigator nav;

    public ApplicationLayout() {
        menu = new MenuBar();
        content = new VerticalLayout();
        nav = new Navigator(UI.getCurrent(), content);
        build();

        addComponents(menu, content);
    }

    public Command navigateTo(final String route) {
        return new Command() {

            @Override
            public void menuSelected(MenuItem selectedItem) {
                nav.navigateTo(route);
            }
        };
    }

    @SuppressWarnings("unchecked")
    public void build() {

        Class<View>[] klasses = new Class[] { AlunoViewList.class,
                CourseList.class, CoordenadorViewList.class, CourseView.class };

        nav.addView("", CourseList.class);
        
        // Static Pages
        nav.addView("page-not-found", PageNotFound.class);

        for (Class<View> klass : klasses) {
            VadinhoMenu vm = klass.getAnnotation(VadinhoMenu.class);
            String route, label;

            if (vm != null) {
                route = (vm.label() == null || vm.route().isEmpty()) ? klass
                        .getSimpleName() : vm.route();
                label = (vm.label() == null || vm.label().isEmpty()) ? klass
                        .getSimpleName() : vm.label();
            } else {
                route = klass.getSimpleName();
                label = klass.getSimpleName();
            }
            
            nav.addView(route, klass);
            menu.addItem(label, navigateTo(route));

        }
    }

}