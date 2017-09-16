
package gerencia.controller;

import gerencia.model.Estabelecimento;
import gerencia.view.TelaEstabelecimento;

public class ControladorEstabelecimento {
    
    private TelaEstabelecimento telaEstabelecimento;
    private ControladorCardapio controladorCardapio;
    private ControladorRelatorio controladorRelatorio;
    private ControladorInicial controladorInicial;
    
    private Estabelecimento estabelecimento;
    
    public ControladorEstabelecimento(){
        this.telaEstabelecimento = new TelaEstabelecimento(this);
    }

    public void abrirTelaRelatorio() {
//        this.controladorRelatorio = new ControladorRelatorio();
//        this.telaEstabelecimento.setVisible(false);
//        this.controladorRelatorio.abrirTela();
    }

    public void abrirTelaCardapio() {
//        this.controladorCardapio = new ControladorCardapio();
//        this.telaEstabelecimento.setVisible(false);
//        this.controladorCardapio.abrirTela();
    }

    public void abrirTela() {
        this.telaEstabelecimento.setVisible(true);
        if (estabelecimento != null){
            telaEstabelecimento.popularCampos(estabelecimento.getNome(), estabelecimento.getQuantidadeMesas());
        }
    }

    public void sair() {
        this.telaEstabelecimento.setVisible(false);
        this.controladorInicial.abrirTela();
    }
    
    public void setControladorInicial(ControladorInicial controladorInicial){
        this.controladorInicial = controladorInicial;
    }

    public void registrarEstabelecimento(String nome, Integer qntMesas) {
        this.estabelecimento = new Estabelecimento(nome, qntMesas);
        this.controladorInicial.setEstabelecimento(estabelecimento);
        this.telaEstabelecimento.mostrarConfirmacao(nome, qntMesas);
    }
    
}
