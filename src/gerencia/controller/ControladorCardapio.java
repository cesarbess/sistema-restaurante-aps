
package gerencia.controller;

import gerencia.view.TelaCardapio;

public class ControladorCardapio {

    private TelaCardapio telaCardapio;
    private ControladorRelatorio controladorRelatorio;
    private ControladorEstabelecimento controladorEstabelecimento;
    
    public ControladorCardapio(){
        this.telaCardapio = new TelaCardapio(this); 
    }

    public void abrirTela() {
        this.telaCardapio.setVisible(true);
    }

    public void abrirTelaRelatorio() {
        this.controladorRelatorio = new ControladorRelatorio();
        this.telaCardapio.setVisible(false);
        this.controladorRelatorio.abrirTela();
    }

    public void abrirTelaEstabelecimento() {
        this.controladorEstabelecimento = new ControladorEstabelecimento();
        this.telaCardapio.setVisible(false);
        this.controladorEstabelecimento.abrirTela();
    }

    public void sair() {
        this.telaCardapio.setVisible(false);
    }
}
