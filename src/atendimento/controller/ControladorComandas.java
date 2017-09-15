
package atendimento.controller;

import atendimento.view.TelaComandas;

public class ControladorComandas {

    private TelaComandas telaComandas;
    private ControladorMesas controladorMesas;
    
    public ControladorComandas(){
        this.telaComandas = new TelaComandas(this);
    }

    public void abrirTela() {
        telaComandas.setVisible(true);
    }

    public void abrirTelaMesas() {
        //Fazer isso para o resto
        if(controladorMesas == null) {
            controladorMesas = new ControladorMesas();
        }
        telaComandas.setVisible(false);
        controladorMesas.abrirTela();
    }

    public void sair() {
        telaComandas.setVisible(false);
    }
            
}
