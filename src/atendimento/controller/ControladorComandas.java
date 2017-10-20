
package atendimento.controller;

import atendimento.model.Comanda;
import atendimento.model.Mesa;
import atendimento.view.TelaComandas;
import atendimento.view.TelaTrocarMesa;
import gerencia.controller.ControladorPrincipal;
import gerencia.model.Estabelecimento;
import gerencia.model.ItemCardapio;
import gerencia.model.StatusItem;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class ControladorComandas {

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }
    
    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    private TelaComandas telaComandas;
    private TelaTrocarMesa telaTrocarMesa;
    private ControladorMesas controladorMesas;
    private ControladorPrincipal controladorInicial;
    private Estabelecimento estabelecimento;
    
    private DefaultListModel comandaModel;
    
    public ControladorComandas(Estabelecimento estabelecimento){
        this.telaComandas = new TelaComandas(this);
        this.estabelecimento = estabelecimento;
        this.telaTrocarMesa = new TelaTrocarMesa(this, estabelecimento.getQuantidadeMesas());
    }

    public void abrirTela() {
        atualizarLista();
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

    public boolean enviarComandaACozinha(Integer numeroMesaSelecionada) {
        Mesa mesa = estabelecimento.getMesaCom(numeroMesaSelecionada);
        boolean tinhaItensPendentes = false;
        for(ItemCardapio item : mesa.getComanda().getItensPedido()){
            if(item.getStatus() == null){
                item.setStatus(StatusItem.EM_ESPERA);
                tinhaItensPendentes = true;
                System.out.println("Alterado o status do item: " + item.getDescricao() + " para " + item.getStatus());
            }
        }
        return tinhaItensPendentes;
    }

    public boolean verificarSeMesaDisponivel(Integer novaMesa) {
        Mesa mesa = estabelecimento.getMesaCom(novaMesa);
        return mesa.isEstaLivre();
    }

    public void trocarMesaDaComanda(Integer idNovaMesa) {
        Integer idMesaSelecionada = this.telaComandas.getIdComandaSelecionada();
        Mesa mesaAntiga = estabelecimento.getMesaCom(idMesaSelecionada);
        Comanda comanda = mesaAntiga.getComanda();
        mesaAntiga.setComanda(null);
        mesaAntiga.setEstaLivre(true);
        Mesa novaMesa = estabelecimento.getMesaCom(idNovaMesa);
        novaMesa.setComanda(comanda);
        comanda.setMesa(novaMesa);
        novaMesa.setEstaLivre(false);
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
}
