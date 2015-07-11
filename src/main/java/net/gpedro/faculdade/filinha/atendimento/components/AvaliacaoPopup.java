package net.gpedro.faculdade.filinha.atendimento.components;

import lombok.Getter;
import net.gpedro.faculdade.filinha.core.components.misc.Alert;
import net.gpedro.faculdade.filinha.shared.atendimento.constants.AVALIACAO;

import org.vaadin.teemu.VaadinIcons;

import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class AvaliacaoPopup extends Window {

    @Getter
    private AVALIACAO avaliacao;
    
    public AvaliacaoPopup() {
        setCaption("Avalie o Atendimento");
        setModal(true);
        setClosable(true);
        setResizable(false);
        setDraggable(false);
        center();
        
        HorizontalLayout layout = new HorizontalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);

        // red
        VerticalLayout ruim = getSmile("#e74c3c");
        ruim.addLayoutClickListener(avalia(AVALIACAO.RUIM));
        
        // yellow
        VerticalLayout bom = getSmile("#f1c40f");
        bom.addLayoutClickListener(avalia(AVALIACAO.BOM));
        
        // green
        VerticalLayout otimo = getSmile("#2ecc71");
        otimo.addLayoutClickListener(avalia(AVALIACAO.OTIMO));
        
        layout.addComponents(ruim, bom, otimo);
        setContent(layout);
    }
    
    private VerticalLayout getSmile(String color) {
        return new VerticalLayout(new Label("<div style=\"cursor:pointer;font-size:3em;color:" + color +  ";\">" +  VaadinIcons.SMILEY_O.getHtml() + "</div>", ContentMode.HTML));
    }
    
    private LayoutClickListener avalia(AVALIACAO avalicao) {
        return new LayoutClickListener() {
            
            @Override
            public void layoutClick(LayoutClickEvent event) {
                AvaliacaoPopup.this.avaliacao = avaliacao;
                AvaliacaoPopup.this.close();
                Alert.showSuccess("Obrigado pela avaliação", null);
            }
        };
    }
    
}
