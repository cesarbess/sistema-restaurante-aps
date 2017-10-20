
package atendimento.controller;

import atendimento.model.Comanda;
import atendimento.model.Mesa;
import atendimento.view.TelaComandas;
import gerencia.controller.ControladorPrincipal;
import gerencia.model.Estabelecimento;
import gerencia.model.ItemCardapio;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class ControladorComandas {

    /**
     * @return the estabelecimento
     */
    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }
    
    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    private TelaComandas telaComandas;
    private ControladorMesas controladorMesas;
    private ControladorPrincipal controladorInicial;
    private Estabelecimento estabelecimento;
    
    private DefaultListModel comandaModel;
    
    public ControladorComandas(){
        this.telaComandas = new TelaComandas(this);
    }

    public void abrirTela() {
        comandaModel = configurarListaComandas();
        telaComandas.setarModeloLista(comandaModel);
        telaComandas.setVisible(true);
    }

    public void abrirTelaMesas() {
        telaComandas.setVisible(false);
        controladorMesas.abrirTela();
    }

    public void sair() {
        telaComandas.setVisible(false);
        this.controladorInicial.abrirTela();
    }

    public void setControladorMesas(ControladorMesas controladorMesas) {
        this.controladorMesas = controladorMesas;
    }

    public void setControladorInicial(ControladorPrincipal controladorInicial) {
        this.controladorInicial = controladorInicial;
    }
    
    private DefaultListModel configurarListaComandas() {
        ArrayList<Comanda> comandas = new ArrayList<>();
        for(Mesa mesa : estabelecimento.getMesas()){
            if(mesa.getComanda() != null){
                comandas.add(mesa.getComanda());
            }
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
            
}
