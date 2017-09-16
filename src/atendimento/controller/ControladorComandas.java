
package atendimento.controller;

import atendimento.view.TelaComandas;
import gerencia.controller.ControladorInicial;

public class ControladorComandas {

    private TelaComandas telaComandas;
    private ControladorMesas controladorMesas;
    private ControladorInicial controladorInicial;
    
    public ControladorComandas(){
        this.telaComandas = new TelaComandas(this);
    }

    public void abrirTela() {
        telaComandas.setVisible(true);
    }

    public void abrirTelaMesas() {
        telaComandas.setVisible(false);
        controladorMesas.abrirTela();
    }

    public void sair() {
        telaComandas.setVisible(false);
        this.controladorInicial.abrirTela();
    }

    public void setControladorMesas(ControladorMesas controladorMesas) {
        this.controladorMesas = controladorMesas;
    }

    public void setControladorInicial(ControladorInicial controladorInicial) {
        this.controladorInicial = controladorInicial;
    }
            
}
