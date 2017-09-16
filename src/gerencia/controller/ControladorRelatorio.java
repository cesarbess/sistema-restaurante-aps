
package gerencia.controller;

import gerencia.view.TelaRelatorio;

public class ControladorRelatorio {
    
    private TelaRelatorio telaRelatorio;
    private ControladorEstabelecimento controladorEstabelecimento;
    private ControladorCardapio controladorCardapio;
    private ControladorInicial controladorInicial;
    
    public ControladorRelatorio(){
        this.telaRelatorio = new TelaRelatorio(this);    
    }

    public void abrirTela() {
        this.telaRelatorio.setVisible(true);
    }

    public void abrirTelaEstabelecimento() {
        telaRelatorio.setVisible(false);
        controladorEstabelecimento.abrirTela();
    }

    public void abrirTelaCardapio() {
        telaRelatorio.setVisible(false);
        controladorCardapio.abrirTela();
    }

    public void sair() {
        telaRelatorio.setVisible(false);
        controladorInicial.abrirTela();
    }
    
    public void setControladorInicial(ControladorInicial controladorInicial){
        this.controladorInicial = controladorInicial;
    }
    
    public void setControladorEstabelecimento(ControladorEstabelecimento controladorEstabelecimento){
        this.controladorEstabelecimento = controladorEstabelecimento;
    }

    public void setControladorCardapio(ControladorCardapio controladorCardapio) {
        this.controladorCardapio = controladorCardapio;
    }
    
}
