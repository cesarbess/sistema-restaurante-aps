
package atendimento.controller;

import atendimento.view.TelaMesas;
import gerencia.controller.ControladorCardapio;

public class ControladorMesas {
    
    private TelaMesas telaMesas;
    private ControladorComandas controladorComandas;
    private ControladorCardapio controladorCardapio;
    
    public ControladorMesas(){
        this.telaMesas = new TelaMesas(this);
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
}
