package net.gpedro.faculdade.filinha.atendimento;

import net.gpedro.faculdade.filinha.atendimento.views.DashboardView;
import net.gpedro.faculdade.filinha.atendimento.views.LoginView;
import net.gpedro.faculdade.filinha.core.util.Session;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@Title("Painel de Atendimento")
@Theme("mytheme")
public class AtendimentoUI extends UI {

    private static final long serialVersionUID = 1243945553082426942L;
    //private static final CoordenadorController cc = new CoordenadorController();

    @Override
    protected void init(VaadinRequest request) {
        if (Session.isLogado()) {
            setContent(new DashboardView());
        } else {
            setContent(new LoginView());
        }
        
        /*Idle.track(this, 15000, new Idle.Listener() {
            
            @Override
            public void userInactive() {
                if (!Session.isLogado()) {
                    return;
                }
                
                Coordenador c = Session.getUsuario();
                if (!c.getSituacao().isEmAtendimento()) {
                    c.setSituacao(STATUS.AUSENTE);
                    
                    cc.save(c);
                }
            }
            
            @Override
            public void userActive() {
                
            }
        });*/
    }

}
