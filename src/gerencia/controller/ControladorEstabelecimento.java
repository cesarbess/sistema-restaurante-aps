
package gerencia.controller;

import gerencia.view.TelaEstabelecimento;

public class ControladorEstabelecimento {
    
    private TelaEstabelecimento telaEstabelecimento;
    private ControladorCardapio controladorCardapio;
    private ControladorRelatorio controladorRelatorio;
    
    public ControladorEstabelecimento(){
        this.telaEstabelecimento = new TelaEstabelecimento(this);
    }

    public void abrirTelaRelatorio() {
        this.controladorRelatorio = new ControladorRelatorio();
        this.telaEstabelecimento.setVisible(false);
        this.controladorRelatorio.abrirTela();
    }

    public void abrirTelaCardapio() {
        this.controladorCardapio = new ControladorCardapio();
        this.telaEstabelecimento.setVisible(false);
        this.controladorCardapio.abrirTela();
    }

    public void abrirTela() {
        this.telaEstabelecimento.setVisible(true);
    }

    public void sair() {
        this.telaEstabelecimento.setVisible(false);
    }
}
