
package gerencia.controller;

import atendimento.model.Comanda;
import atendimento.model.Mesa;
import gerencia.model.Estabelecimento;
import gerencia.view.TelaRelatorio;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class ControladorRelatorio {
    
    private TelaRelatorio telaRelatorio;
    private ControladorEstabelecimento controladorEstabelecimento;
    private ControladorCardapio controladorCardapio;
    private ControladorPrincipal controladorPrincipal;
    
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
        controladorPrincipal.abrirTela();
    }
    
    public void setControladorInicial(ControladorPrincipal controladorInicial){
        this.controladorPrincipal = controladorInicial;
    }
    
    public void setControladorEstabelecimento(ControladorEstabelecimento controladorEstabelecimento){
        this.controladorEstabelecimento = controladorEstabelecimento;
    }

    public void setControladorCardapio(ControladorCardapio controladorCardapio) {
        this.controladorCardapio = controladorCardapio;
    }

    public DefaultListModel gerarRelatorio(boolean naCozinha, boolean entregue) {
        ArrayList<Comanda> comandas = new ArrayList<>();
        if(naCozinha) {
            comandas.addAll(gerarRelatorioComandasCozinha());
        }
        if(entregue) {
            comandas.addAll(gerarRelatorioEntregue());
        }
        
        DefaultListModel model = new DefaultListModel();
        if(comandas.size()>=0){
            for(int i = 0; i < comandas.size(); i++){
               model.add(i, comandas.get(i).getDescrição());
            }
            return model;
        }
        return model;
    }

    private ArrayList<Comanda> gerarRelatorioComandasCozinha() {
        ArrayList<Comanda> comandas = new ArrayList<>();
        
        for(Mesa mesa : Estabelecimento.getInstance().getMesas()){
            if(mesa.getComanda() != null && mesa.getComanda().getItensPedido() != null){
                if(mesa.getComanda().possuiItemAtivoNaCozinha()){
                    comandas.add(mesa.getComanda());
                }
            }
        }
        return comandas;
    }

    private ArrayList<Comanda> gerarRelatorioEntregue() {
        ArrayList<Comanda> comandas = new ArrayList<>();
        
        for(Mesa mesa : Estabelecimento.getInstance().getMesas()){
            if(mesa.getComanda() != null && mesa.getComanda().getItensPedido() != null){
                if(mesa.getComanda().possuiTodosItensEntregues()){
                    comandas.add(mesa.getComanda());
                }
            }
        }
        return comandas;
    }
}
