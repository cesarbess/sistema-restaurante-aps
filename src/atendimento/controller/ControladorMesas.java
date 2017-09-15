
package atendimento.controller;

import atendimento.view.TelaMesas;
import gerencia.controller.ControladorCardapio;
import gerencia.model.Estabelecimento;

public class ControladorMesas {
    
    private TelaMesas telaMesas;
    private ControladorComandas controladorComandas;
    private ControladorCardapio controladorCardapio;
    
    private Estabelecimento estabelecimento;
    
    public ControladorMesas(){
        this.telaMesas = new TelaMesas(this, this.estabelecimento.getQuantidadeMesas());
    }
    
    public ControladorMesas(Estabelecimento estabelecimento){
        this.estabelecimento = estabelecimento;
        this.telaMesas = new TelaMesas(this, this.estabelecimento.getQuantidadeMesas());
    }

    public void abrirTela() {
        this.telaMesas.setVisible(true);
    }

    public void abrirTelaComandas() {
        this.controladorComandas = new ControladorComandas();
        telaMesas.setVisible(false);
        this.controladorComandas.abrirTela();
    }

    public void sair() {
        telaMesas.setVisible(false);
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }
}
