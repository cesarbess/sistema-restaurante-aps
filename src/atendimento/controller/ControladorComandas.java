
package atendimento.controller;

import atendimento.model.Comanda;
import atendimento.model.Mesa;
import atendimento.view.TelaComandas;
import atendimento.view.TelaStatusItens;
import atendimento.view.TelaTrocarMesa;
import gerencia.controller.ControladorPrincipal;
import gerencia.model.Estabelecimento;
import gerencia.model.ItemCardapio;
import gerencia.model.StatusItem;
import gerencia.model.TipoPerfil;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class ControladorComandas {
    
    private TelaComandas telaComandas;
    private TelaTrocarMesa telaTrocarMesa;
    private TelaStatusItens telaStatusItens;
    
    private ControladorMesas controladorMesas;
    private ControladorPrincipal controladorPrincipal;
    
    private DefaultListModel comandaModel;
    
    public ControladorComandas(ControladorPrincipal controladorPrincipal){
        this.telaComandas = new TelaComandas(this);
        this.telaTrocarMesa = new TelaTrocarMesa(this, Estabelecimento.getInstance().getQuantidadeMesas());
        this.telaStatusItens = new TelaStatusItens(this);
        this.controladorPrincipal = controladorPrincipal;
    }

    public void abrirTela() {
        atualizarLista();
        telaComandas.configurarTelaParaPerfil(Estabelecimento.getInstance().getPerfilEmUso());
        telaComandas.setVisible(true);
    }

    public void abrirTelaMesas() {
        telaComandas.setVisible(false);
        controladorMesas.abrirTela();
    }

    public void sair() {
        telaComandas.setVisible(false);
        this.controladorPrincipal.abrirTela();
    }

    public void setControladorMesas(ControladorMesas controladorMesas) {
        this.controladorMesas = controladorMesas;
    }

    public void setControladorInicial(ControladorPrincipal controladorInicial) {
        this.controladorPrincipal = controladorInicial;
    }
    
    private DefaultListModel configurarListaComandas() {
        ArrayList<Comanda> comandas = new ArrayList<>();
        for(Mesa mesa : Estabelecimento.getInstance().getMesas()){
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
    
    private DefaultListModel configurarListaItensComanda(Integer idMesa) {
        ArrayList<ItemCardapio> itens = new ArrayList<>();
        Mesa mesa = Estabelecimento.getInstance().getMesaCom(idMesa);
        if (mesa.getComanda() != null && mesa.getComanda().getItensPedido() != null) {
            for(ItemCardapio item : mesa.getComanda().getItensPedido()) {
                itens.add(item);
            }
        }                
        DefaultListModel model = new DefaultListModel();
        if(itens.size()>=0){
            for(int i = 0; i < itens.size(); i++){
               model.add(i, itens.get(i).getDescricao());
            }
            return model;
        }
        return model;
    }

    public boolean enviarComandaACozinha(Integer numeroMesaSelecionada) {
        Mesa mesa = Estabelecimento.getInstance().getMesaCom(numeroMesaSelecionada);
        boolean tinhaItensPendentes = false;
        for(ItemCardapio item : mesa.getComanda().getItensPedido()){
            if(item.getStatus() == null){
                item.setStatus(StatusItem.EM_ESPERA);
                tinhaItensPendentes = true;
            }
        }
        if (tinhaItensPendentes) {
            controladorPrincipal.salvarNoDisco();
        }
        return tinhaItensPendentes;
    }

    public boolean verificarSeMesaDisponivel(Integer novaMesa) {
        Mesa mesa = Estabelecimento.getInstance().getMesaCom(novaMesa);
        return mesa.isEstaLivre();
    }

    public void trocarMesaDaComanda(Integer idNovaMesa) {
        Integer idMesaSelecionada = this.telaComandas.getIdComandaSelecionada();
        Mesa mesaAntiga = Estabelecimento.getInstance().getMesaCom(idMesaSelecionada);
        Comanda comanda = mesaAntiga.getComanda();
        mesaAntiga.setComanda(null);
        mesaAntiga.setEstaLivre(true);
        controladorMesas.atualizarCorBotoesMesa(idMesaSelecionada.toString(), false);
        Mesa novaMesa = Estabelecimento.getInstance().getMesaCom(idNovaMesa);
        novaMesa.setComanda(comanda);
        comanda.setMesa(novaMesa);
        novaMesa.setEstaLivre(false);
        controladorMesas.atualizarCorBotoesMesa(idNovaMesa.toString(), true);
        controladorPrincipal.salvarNoDisco();
        atualizarLista();
        System.out.println("Troquei comanda da mesa " + mesaAntiga.getId() + " para a mesa: " + novaMesa.getId());
    }

    public void abrirTelaTrocarMesa() {
        this.telaTrocarMesa.setVisible(true);
    }

    private void atualizarLista() {
        comandaModel = configurarListaComandas();
        telaComandas.setarModeloLista(comandaModel);
    }

    public boolean comandaPossuiItemQueExigePreparo(Integer numeroMesaSelecionada) {
        Comanda comanda = Estabelecimento.getInstance().getMesaCom(numeroMesaSelecionada).getComanda();
        return comanda.possuiItensQueExigePreparo();
    }

    public void abrirTelaStatusItens(Integer numeroMesaSelecionada) {
        DefaultListModel modeloItens = configurarListaItensComanda(numeroMesaSelecionada);
        telaStatusItens.setIdMesa(numeroMesaSelecionada);
        telaStatusItens.setarModeloLista(modeloItens);
        telaStatusItens.setVisible(true);
    }

    public void atualizarTelaParaItem(String nome, Integer idMesa) {
        Mesa mesa = Estabelecimento.getInstance().getMesaCom(idMesa);
        Comanda comanda = mesa.getComanda();
        ItemCardapio item;
        for(ItemCardapio i : comanda.getItensPedido()){
            if(i.getDescricao().contains(nome)){
                item = i;
                String proximoStatus = item.getProximoStatus();
                telaStatusItens.atualizarTelaParaStatus(item.getDescricaoStatus(), proximoStatus);
                controladorPrincipal.salvarNoDisco();
                break;
            }
        }
    }

    public void avancarStatusItem(String itemSelecionado, Integer idMesa) {
        Mesa mesa = Estabelecimento.getInstance().getMesaCom(idMesa);
        Comanda comanda = mesa.getComanda();
        for(ItemCardapio item : comanda.getItensPedido()){
            if(item.getDescricao().equals(itemSelecionado)){
                String proximo = item.getProximoStatus();
                if(proximo.equals("Em preparo") || proximo.equals("Pronto")) {
                    if(ehGarcom()){
                        telaStatusItens.mostrarAvisoParaPerfilInvalido(Estabelecimento.getInstance().getPerfilEmUso(), proximo);
                        break;
                    }
                } else if(proximo.equals("Entregue") && !ehGarcom()) {
                    telaStatusItens.mostrarAvisoParaPerfilInvalido(Estabelecimento.getInstance().getPerfilEmUso(), proximo);
                    break;
                }
                item.avancarStatus();
                String proximoStatus = item.getProximoStatus();
                controladorPrincipal.salvarNoDisco();
                telaStatusItens.atualizarTelaParaStatus(item.getDescricaoStatus(), proximoStatus);
                break;
            }
        }
    }

    public boolean cancelarItem(String itemSelecionado, Integer idMesa) {
        Mesa mesa = Estabelecimento.getInstance().getMesaCom(idMesa);
        Comanda comanda = mesa.getComanda();
        for(ItemCardapio item : comanda.getItensPedido()){
            if(item.getDescricao().equals(itemSelecionado)){
                if(item.getStatus() == StatusItem.ENTREGUE){
                    return false;
                }
                item.cancelar();
                String proximoStatus = item.getProximoStatus();
                controladorPrincipal.salvarNoDisco();
                telaStatusItens.atualizarTelaParaStatus(item.getDescricaoStatus(), proximoStatus);
                return true;
            }
        }
        return false;
    }

    public boolean ehGarcom() {
        return Estabelecimento.getInstance().getPerfilEmUso() == TipoPerfil.GARCOM;
    }

    public boolean comandaFoiEnviadaACozinha(Integer idComandaSelecionada) {
        Comanda comanda = Estabelecimento.getInstance().getMesaCom(idComandaSelecionada).getComanda();
        return comanda.jaFoiEnviadaACozinha();
    }
}

