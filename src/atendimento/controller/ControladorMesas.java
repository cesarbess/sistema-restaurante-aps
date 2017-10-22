
package atendimento.controller;

import atendimento.model.Comanda;
import atendimento.view.TelaMesas;
import gerencia.controller.ControladorPrincipal;
import gerencia.model.Estabelecimento;
import atendimento.model.Mesa;
import atendimento.view.TelaGerirComanda;
import gerencia.model.ItemCardapio;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class ControladorMesas {
    
    private TelaMesas telaMesas;
    private TelaGerirComanda telaGerirComanda;

    private ControladorComandas controladorComandas;
    private ControladorPrincipal controladorPrincipal;

    private DefaultListModel comandaModel;
    private ArrayList<String> listaItensComanda;
   
    public ControladorMesas(ControladorPrincipal controladorInicial) {
        this.controladorPrincipal = controladorInicial;
        this.telaMesas = new TelaMesas(this, Estabelecimento.getInstance().getQuantidadeMesas());
        this.telaGerirComanda = new TelaGerirComanda(this);
        configurarControlador();
        comandaModel = new DefaultListModel();
        listaItensComanda = new ArrayList<>();
    }

    public void abrirTela() {
        this.telaMesas.setVisible(true);
    }

    public void abrirTelaComandas() {
        telaMesas.setVisible(false);
        controladorComandas.abrirTela();
    }

    public void sair() {
        telaMesas.setVisible(false);
        this.controladorPrincipal.abrirTela();
    }

    private void configurarControlador() {
        controladorComandas = new ControladorComandas(controladorPrincipal);
        controladorComandas.setControladorMesas(this);
    }

    public boolean mesaLivre(Integer idMesa) {
        for(Mesa mesa : Estabelecimento.getInstance().getMesas()){
           if(mesa.getId().equals(idMesa) && !mesa.isEstaLivre()){
               return false;
           } 
        }
        return true;
    }

    public boolean ocuparMesa(int idMesa) {
        for(Mesa mesa : Estabelecimento.getInstance().getMesas()){
           if(mesa.getId().equals(idMesa) && mesa.isEstaLivre()){
               mesa.setEstaLivre(false);
               return true;
           } else if (mesa.getId().equals(idMesa) && !mesa.isEstaLivre()){
               return false;
           }
        }
        return false;
    }

    public boolean liberarMesa(int idMesa) {
        for(Mesa mesa : Estabelecimento.getInstance().getMesas()){
           if(mesa.getId().equals(idMesa) && !mesa.isEstaLivre()){
               //TODO checar se comanda esta ativa
               mesa.setEstaLivre(true);
               return true;
           } else if (mesa.getId().equals(idMesa) && mesa.isEstaLivre()){
               return false;
           }
        }
        return false;
    }

    public void abrirTelaGerirComanda() {
        this.telaGerirComanda.setVisible(true);
        atualizarCardapioNaTela();
    }
    
    private DefaultListModel configurarCardapio() {
        ArrayList<ItemCardapio> itens = Estabelecimento.getInstance().getCardapio().getItens();
        DefaultListModel model = new DefaultListModel();
        if(itens.size()>=0){
            for(int i = 0; i < itens.size(); i++){
                if(itens.get(i).isExigePreparo()){
                    model.add(i, itens.get(i).getDescricao()+ "   " + "(Exige preparo)");
                } else{
                    model.add(i, itens.get(i).getDescricao());    
                }
            }
            return model;
        }
        return model;
    }
    
    private void atualizarCardapioNaTela() {
        DefaultListModel modelCardapio = configurarCardapio();
        telaGerirComanda.setarModeloLista(modelCardapio);
    }

    public void adicionarItemNaComanda(String item) {
        listaItensComanda.add(item);
        comandaModel.addElement(item);
        telaGerirComanda.setComandaListModel(comandaModel);
        for(String i : listaItensComanda){
            System.out.println(i);
        }
    }

    public void removerItemNaComanda(String item) {
        listaItensComanda.remove(item);
        comandaModel.removeElement(item);
        telaGerirComanda.setComandaListModel(comandaModel);
        for(String i : listaItensComanda){
            System.out.println(i);
        }
    }

    public void zerarComanda() {
        comandaModel.removeAllElements();
        listaItensComanda.removeAll(listaItensComanda);
    }

    public void criaComanda() {
        Integer idMesa = this.telaMesas.getIdMesaSelecionada();
        Comanda novaComanda = new Comanda(Estabelecimento.getInstance().getMesaCom(idMesa));
        for(String item : listaItensComanda){
            for(ItemCardapio itemCardapio : Estabelecimento.getInstance().getCardapio().getItens()){
                if(item.contains(itemCardapio.getDescricao())){
                    novaComanda.adicionarItemNaComanda(itemCardapio);
                }
            }
        }
        
        Estabelecimento.getInstance().ocuparMesa(idMesa, novaComanda);
        telaGerirComanda.setVisible(false);
        zerarComanda();
    }

    public boolean mesaPossuiComanda(Integer idMesaSelecionada) {
        Mesa mesa = Estabelecimento.getInstance().getMesaCom(idMesaSelecionada);
        return mesa.getComanda() != null;
    }

    public void cancelarComanda(Integer idMesaSelecionada) {
        //PRECISA CHECAR SE A COMANDA POSSUI ITENS ATIVO NA COZINHA
        Mesa mesa = Estabelecimento.getInstance().getMesaCom(idMesaSelecionada);
        mesa.setComanda(null);
    }
}
