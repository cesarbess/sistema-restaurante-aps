
package gerencia.controller;

import gerencia.model.Cardapio;
import gerencia.model.Estabelecimento;
import gerencia.view.TelaEstabelecimento;

public class ControladorEstabelecimento {
    
    private TelaEstabelecimento telaEstabelecimento;
    private ControladorCardapio controladorCardapio;
    private ControladorRelatorio controladorRelatorio;
    private ControladorPrincipal controladorPrincipal;
    
    private Estabelecimento estabelecimento;
   
    public ControladorEstabelecimento(ControladorPrincipal controladorInicial) {
        this.controladorPrincipal = controladorInicial;
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
        this.controladorPrincipal.abrirTela();
    }
    
    public void setControladorInicial(ControladorPrincipal controladorInicial){
        this.controladorPrincipal = controladorInicial;
    }

    public void registrarEstabelecimento(String nome, Integer qntMesas) {
        this.estabelecimento = new Estabelecimento(nome, qntMesas);
        this.estabelecimento.setCardapio(new Cardapio());
        this.controladorPrincipal.setEstabelecimento(estabelecimento);
        this.telaEstabelecimento.mostrarConfirmacao(nome, qntMesas);
    }

    public void setControladorCardapio(ControladorCardapio controladorCardapio) {
        this.controladorCardapio = controladorCardapio;
    }

    private void configurarControladores() {
        controladorCardapio = new ControladorCardapio();
        controladorCardapio.setControladorEstabelecimento(this);
        controladorCardapio.setControladorInicial(controladorPrincipal);
        
        controladorRelatorio = new ControladorRelatorio();
        controladorRelatorio.setControladorEstabelecimento(this);
        controladorRelatorio.setControladorInicial(controladorPrincipal);
        
        controladorCardapio.setControladorRelatorio(controladorRelatorio);
        controladorRelatorio.setControladorCardapio(controladorCardapio);    
    }

    public boolean PossuiEstabelecimentoConfigurado() {
        return this.estabelecimento != null;
    }
    
}
