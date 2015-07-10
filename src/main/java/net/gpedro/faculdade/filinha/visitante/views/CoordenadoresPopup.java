package net.gpedro.faculdade.filinha.visitante.views;

import java.util.HashMap;
import java.util.List;

import lombok.Getter;
import net.gpedro.faculdade.filinha.shared.rh.model.Coordenador;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class CoordenadoresPopup extends Window {

    @Getter
    private Coordenador                  coordenadorSelecionado;
    private HashMap<String, Coordenador> map;

    public CoordenadoresPopup(List<Coordenador> coordenadores) {
        map = new HashMap<String, Coordenador>();

        setModal(true);
        setCaption("Selecione um Coordenador");
        setResizable(false);
        setDraggable(false);

        VerticalLayout layout = new VerticalLayout();
        layout.setSpacing(true);
        layout.setMargin(true);

        Label titulo = new Label(
                "Vários Coordenadores foram encontrados para esta matéria. Por favor, selecione um.");
        layout.addComponent(titulo);

        for (Coordenador coordenador : coordenadores) {
            map.put(coordenador.getId().toString(), coordenador);

            Button btn = new Button(coordenador.getNome());
            btn.setSizeFull();
            btn.setId(coordenador.getId().toString());
            btn.addClickListener(continuar());

            layout.addComponent(btn);
        }

        setContent(layout);

    }

    public ClickListener continuar() {
        return new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                Button btn = event.getButton();
                coordenadorSelecionado = map.get(btn.getId());
                CoordenadoresPopup.this.close();
            }
        };
    }
}
