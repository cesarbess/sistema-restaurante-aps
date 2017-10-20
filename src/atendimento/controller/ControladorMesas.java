
package atendimento.controller;

import atendimento.model.Comanda;
import atendimento.view.TelaMesas;
import gerencia.controller.ControladorCardapio;
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
    
    private Estabelecimento estabelecimento;
    private DefaultListModel comandaModel;
    private ArrayList<String> listaItensComanda;
    
    public ControladorMesas(){
        this.telaMesas = new TelaMesas(this, this.estabelecimento.getQuantidadeMesas());
        this.telaGerirComanda = new TelaGerirComanda(this);
        comandaModel = new DefaultListModel();
        listaItensComanda = new ArrayList<>();
    }
   
    public ControladorMesas(ControladorPrincipal controladorInicial, Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
        this.controladorPrincipal = controladorInicial;
        this.telaMesas = new TelaMesas(this, this.estabelecimento.getQuantidadeMesas());
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
        controladorComandas.setEstabelecimento(estabelecimento);
        controladorComandas.abrirTela();
    }

    public void sair() {
        telaMesas.setVisible(false);
        this.controladorPrincipal.abrirTela();
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    private void configurarControlador() {
        controladorComandas = new ControladorComandas(this.estabelecimento);
        controladorComandas.setControladorMesas(this);
        controladorComandas.setControladorInicial(controladorPrincipal);
    }

    public boolean mesaLivre(Integer idMesa) {
        for(Mesa mesa : estabelecimento.getMesas()){
           if(mesa.getId().equals(idMesa) && !mesa.isEstaLivre()){
               return false;
           } 
        }
        return true;
    }

    public boolean ocuparMesa(int idMesa) {
        for(Mesa mesa : estabelecimento.getMesas()){
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
        for(Mesa mesa : estabelecimento.getMesas()){
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
        ArrayList<ItemCardapio> itens = estabelecimento.getCardapio().getItens();
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
        Comanda novaComanda = new Comanda(this.estabelecimento.getMesaCom(idMesa));
        for(String item : listaItensComanda){
            for(ItemCardapio itemCardapio : estabelecimento.getCardapio().getItens()){
                if(item.contains(itemCardapio.getDescricao())){
                    novaComanda.adicionarItemNaComanda(itemCardapio);
                }
            }
        }
        
        estabelecimento.ocuparMesa(idMesa, novaComanda);
        telaGerirComanda.setVisible(false);
        zerarComanda();
    }

    public boolean mesaPossuiComanda(Integer idMesaSelecionada) {
        Mesa mesa = estabelecimento.getMesaCom(idMesaSelecionada);
        return mesa.getComanda() != null;
    }

    public void cancelarComanda(Integer idMesaSelecionada) {
        //PRECISA CHECAR SE A COMANDA POSSUI ITENS ATIVO NA COZINHA
        Mesa mesa = estabelecimento.getMesaCom(idMesaSelecionada);
        mesa.setComanda(null);
    }
}
