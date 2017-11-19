
package atendimento.controller;

import atendimento.model.Comanda;
import atendimento.view.TelaMesas;
import gerencia.controller.ControladorPrincipal;
import gerencia.model.Estabelecimento;
import atendimento.model.Mesa;
import atendimento.view.TelaGerirComanda;
import gerencia.model.ItemCardapio;
import gerencia.model.StatusItem;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class ControladorMesas {
    
    private TelaMesas telaMesas;
    private TelaGerirComanda telaGerirComanda;

    private ControladorComandas controladorComandas;
    private ControladorPrincipal controladorPrincipal;

    private DefaultListModel comandaModel;
    private ArrayList<String> listaItensComanda;
    private ArrayList<Integer> mesasOcupadas;
   
    public ControladorMesas(ControladorPrincipal controladorInicial) {
        mesasOcupadas = new ArrayList<>();
        for(Mesa mesa : Estabelecimento.getInstance().getMesas()){
            if(!mesa.isEstaLivre()){
                mesasOcupadas.add(mesa.getId());
            }
        }
        this.controladorPrincipal = controladorInicial;
        this.telaMesas = new TelaMesas(this, Estabelecimento.getInstance().getQuantidadeMesas(), mesasOcupadas);
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
    
    public void atualizarCorBotoesMesa(String idMesa, boolean ocupando) {
        this.telaMesas.alterarCorBotaoMesa(idMesa, ocupando);
    }

    public boolean isMesaLivre(Integer idMesa) {
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
               controladorPrincipal.salvarNoDisco();
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
               if (mesa.getComanda() != null && mesa.possuiComandaAtivaNaCozinha()){
                   return false;
               } else if(mesa.getComanda() != null && !mesa.possuiComandaAtivaNaCozinha()){
                   mesa.setComanda(null);
                   mesa.setEstaLivre(true);
                   controladorPrincipal.salvarNoDisco();
                   return true;
               } else {
                   mesa.setEstaLivre(true);
                   controladorPrincipal.salvarNoDisco();
                   return true;
               }
           } else if (mesa.getId().equals(idMesa) && mesa.isEstaLivre()){
               return false;
           }
        }
        return false;
    }

    public void abrirTelaCriarComanda() {
        this.telaGerirComanda.setVisible(true);
        this.telaGerirComanda.setComandaListModel(new DefaultListModel());
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
                    if(!itemCardapio.isExigePreparo()){
                        itemCardapio.setStatus(StatusItem.PRONTO);
                    }
                    novaComanda.adicionarItemNaComanda(itemCardapio);
                }
            }
        }
        
        Estabelecimento.getInstance().ocuparMesa(idMesa, novaComanda);
        telaGerirComanda.setVisible(false);
        telaMesas.setModoEdicao(true);
        controladorPrincipal.salvarNoDisco();
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
        mesa.setEstaLivre(true);
        controladorPrincipal.salvarNoDisco();
        this.telaMesas.alterarCorBotaoMesa(mesa.getId().toString(), false);
    }

    public void abrirTelaEdicaoComanda(Integer idMesaSelecionada) {
        this.telaGerirComanda.setComandaListModel(this.getItensComandaModel(idMesaSelecionada));
        atualizarCardapioNaTela();
        this.telaGerirComanda.setVisible(true);
    }
    
    private DefaultListModel getItensComandaModel(Integer mesaID){
        Comanda comanda = Estabelecimento.getInstance().getMesaCom(mesaID).getComanda();
        DefaultListModel model = new DefaultListModel();
        for(int i = 0; i < comanda.getItensPedido().size(); i++){
            if(comanda.getItensPedido().get(i).isExigePreparo()){
                model.add(i, comanda.getItensPedido().get(i).getDescricao()+ "   " + "(Exige preparo)");
            } else{
                model.add(i, comanda.getItensPedido().get(i).getDescricao());    
            }
        }
        return model;
    }
}
