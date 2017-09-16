
package gerencia.controller;

import gerencia.view.TelaCardapio;

public class ControladorCardapio {

    private TelaCardapio telaCardapio;
    private ControladorRelatorio controladorRelatorio;
    private ControladorEstabelecimento controladorEstabelecimento;
    private ControladorInicial controladorInicial;
    
    public ControladorCardapio(){
        telaCardapio = new TelaCardapio(this); 
    }

    public void abrirTela() {
        telaCardapio.setVisible(true);
    }

    public void abrirTelaRelatorio() {
        telaCardapio.setVisible(false);
        controladorRelatorio.abrirTela();
    }

    public void abrirTelaEstabelecimento() {
        telaCardapio.setVisible(false);
        controladorEstabelecimento.abrirTela();
    }

    public void sair() {
        this.telaCardapio.setVisible(false);
        controladorInicial.abrirTela();
    }
    
    public void setControladorInicial(ControladorInicial controladorInicial){
        this.controladorInicial = controladorInicial;
    }

    public void setControladorEstabelecimento(ControladorEstabelecimento controladorEstabelecimento) {
        this.controladorEstabelecimento = controladorEstabelecimento;
    }

    public void setControladorRelatorio(ControladorRelatorio controladorRelatorio) {
        this.controladorRelatorio = controladorRelatorio;
    }
}
