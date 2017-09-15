
package gerencia.controller;

import gerencia.view.TelaRelatorio;

public class ControladorRelatorio {
    
    private TelaRelatorio telaRelatorio;
    private ControladorEstabelecimento controladorEstabelecimento;
    private ControladorCardapio controladorCardapio;
    
    public ControladorRelatorio(){
        this.telaRelatorio = new TelaRelatorio(this);    
    }

    public void abrirTela() {
        this.telaRelatorio.setVisible(true);
    }

    public void abrirTelaEstabelecimento() {
        this.controladorEstabelecimento = new ControladorEstabelecimento();
        this.telaRelatorio.setVisible(false);
        this.controladorEstabelecimento.abrirTela();
    }

    public void abrirTelaCardapio() {
        this.controladorCardapio = new ControladorCardapio();
        this.telaRelatorio.setVisible(false);
        this.controladorCardapio.abrirTela();
    }

    public void sair() {
        this.telaRelatorio.setVisible(false);
    }
    
}
