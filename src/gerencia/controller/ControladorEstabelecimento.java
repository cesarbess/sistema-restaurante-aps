
package gerencia.controller;

import gerencia.model.Estabelecimento;
import gerencia.view.TelaEstabelecimento;

public class ControladorEstabelecimento {
    
    private TelaEstabelecimento telaEstabelecimento;
    private ControladorCardapio controladorCardapio;
    private ControladorRelatorio controladorRelatorio;
    private ControladorInicial controladorInicial;
    
    private Estabelecimento estabelecimento;
   
    public ControladorEstabelecimento(ControladorInicial controladorInicial) {
        this.controladorInicial = controladorInicial;
        telaEstabelecimento = new TelaEstabelecimento(this);
        configurarControladores();
    }

    public void abrirTelaRelatorio() {
        telaEstabelecimento.setVisible(false);
        controladorRelatorio.abrirTela();
    }

    public void abrirTelaCardapio() {
        telaEstabelecimento.setVisible(false);
        controladorCardapio.abrirTela();
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

    public void setControladorCardapio(ControladorCardapio controladorCardapio) {
        this.controladorCardapio = controladorCardapio;
    }

    private void configurarControladores() {
        controladorCardapio = new ControladorCardapio();
        controladorCardapio.setControladorEstabelecimento(this);
        controladorCardapio.setControladorInicial(controladorInicial);
        
        controladorRelatorio = new ControladorRelatorio();
        controladorRelatorio.setControladorEstabelecimento(this);
        controladorRelatorio.setControladorInicial(controladorInicial);
        
        controladorCardapio.setControladorRelatorio(controladorRelatorio);
        controladorRelatorio.setControladorCardapio(controladorCardapio);    
    }
    
}
