
package atendimento.controller;

import atendimento.view.TelaMesas;
import gerencia.controller.ControladorCardapio;
import gerencia.controller.ControladorPrincipal;
import gerencia.model.Estabelecimento;

public class ControladorMesas {
    
    private TelaMesas telaMesas;
    private ControladorComandas controladorComandas;
    private ControladorCardapio controladorCardapio;
    private ControladorPrincipal controladorInicial;
    
    private Estabelecimento estabelecimento;
    
    public ControladorMesas(){
        this.telaMesas = new TelaMesas(this, this.estabelecimento.getQuantidadeMesas());
    }
   
    public ControladorMesas(ControladorPrincipal controladorInicial, Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
        this.controladorInicial = controladorInicial;
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
        this.controladorInicial.abrirTela();
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    private void configurarControlador() {
        controladorComandas = new ControladorComandas();
        controladorComandas.setControladorMesas(this);
        controladorComandas.setControladorInicial(controladorInicial);
    }
}
