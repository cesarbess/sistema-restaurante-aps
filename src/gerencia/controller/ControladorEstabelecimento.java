
package gerencia.controller;

import atendimento.model.Mesa;
import gerencia.model.Cardapio;
import gerencia.model.Estabelecimento;
import gerencia.view.TelaEstabelecimento;
import java.util.ArrayList;

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
        this.estabelecimento = Estabelecimento.getInstance();
        this.estabelecimento.setNome(nome);
        this.estabelecimento.setQuantidadeMesas(qntMesas);
        this.estabelecimento.setCardapio(new Cardapio());
        this.telaEstabelecimento.mostrarConfirmacao(nome, qntMesas);
        for(int i = 0; i < qntMesas; i++){
            Mesa mesa = new Mesa(i+1);
            this.estabelecimento.getMesas().add(mesa);
            System.out.println("Mesa com ID: " + mesa.getId() + "adicionada no array de mesas");
        }
    }

    public void setControladorCardapio(ControladorCardapio controladorCardapio) {
        this.controladorCardapio = controladorCardapio;
    }

    private void configurarControladores() {
        controladorCardapio = new ControladorCardapio(controladorPrincipal);
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
