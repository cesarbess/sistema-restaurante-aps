
package atendimento.controller;

import atendimento.view.TelaMesas;
import gerencia.controller.ControladorCardapio;
import gerencia.controller.ControladorPrincipal;
import gerencia.model.Estabelecimento;
import gerencia.model.Mesa;

public class ControladorMesas {
    
    private TelaMesas telaMesas;
    private ControladorComandas controladorComandas;
    private ControladorCardapio controladorCardapio;
    private ControladorPrincipal controladorPrincipal;
    
    private Estabelecimento estabelecimento;
    
    public ControladorMesas(){
        this.telaMesas = new TelaMesas(this, this.estabelecimento.getQuantidadeMesas());
    }
   
    public ControladorMesas(ControladorPrincipal controladorInicial, Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
        this.controladorPrincipal = controladorInicial;
        this.telaMesas = new TelaMesas(this, this.estabelecimento.getQuantidadeMesas());
        configurarControlador();
    }

    public void abrirTela() {
        this.telaMesas.setVisible(true);
    }

    public void abrirTelaComandas() {
        telaMesas.setVisible(false);
        this.controladorComandas.abrirTela();
    }

    public void sair() {
        telaMesas.setVisible(false);
        this.controladorPrincipal.abrirTela();
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    private void configurarControlador() {
        controladorComandas = new ControladorComandas();
        controladorComandas.setControladorMesas(this);
        controladorComandas.setControladorInicial(controladorPrincipal);
    }

    public boolean mesaLivre(Integer idMesa) {
        Estabelecimento estabelecimento = controladorPrincipal.getEstabelecimento();
        for(Mesa mesa : estabelecimento.getMesas()){
           if(mesa.getId().equals(idMesa) && !mesa.isEstaLivre()){
               return false;
           } 
        }
        return true;
    }

    public boolean ocuparMesa(int idMesa) {
        Estabelecimento estabelecimento = controladorPrincipal.getEstabelecimento();
        for(Mesa mesa : estabelecimento.getMesas()){
           if(mesa.getId().equals(idMesa) && mesa.isEstaLivre()){
               mesa.setEstaLivre(false);
               return true;
           } else if (mesa.getId().equals(idMesa) && !mesa.isEstaLivre()){
               return false;
           }
        }
        return false;
    }

    public boolean liberarMesa(int idMesa) {
        Estabelecimento estabelecimento = controladorPrincipal.getEstabelecimento();
        for(Mesa mesa : estabelecimento.getMesas()){
           if(mesa.getId().equals(idMesa) && !mesa.isEstaLivre()){
               //TODO checar se comanda esta ativa
               mesa.setEstaLivre(true);
               return true;
           } else if (mesa.getId().equals(idMesa) && mesa.isEstaLivre()){
               return false;
           }
        }
        return false;
    }
}
