
package gerencia.controller;

import gerencia.model.Estabelecimento;
import gerencia.view.TelaCardapio;
import gerencia.view.TelaItem;
import gerencia.model.ItemCardapio;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class ControladorCardapio {

    private TelaCardapio telaCardapio;
    private TelaItem telaItem;
    private ControladorRelatorio controladorRelatorio;
    private ControladorEstabelecimento controladorEstabelecimento;
    private ControladorPrincipal controladorPrincipal;
    
    public ControladorCardapio(ControladorPrincipal controladorPrincipal){
        this.controladorPrincipal = controladorPrincipal;
        telaCardapio = new TelaCardapio(this); 
        telaItem = new TelaItem(this);
    }

    public void abrirTela() {
        telaCardapio.setVisible(true);
        atualizarCardapioNaTela();
    }

    public void abrirTelaRelatorio() {
        telaCardapio.setVisible(false);
        controladorRelatorio.abrirTela();
    }

    public void abrirTelaEstabelecimento() {
        telaCardapio.setVisible(false);
        controladorEstabelecimento.abrirTela();
    }

    public void sair() {
        this.telaCardapio.setVisible(false);
        controladorPrincipal.abrirTela();
    }
    
    public void setControladorInicial(ControladorPrincipal controladorInicial){
        this.controladorPrincipal = controladorInicial;
    }

    public void setControladorEstabelecimento(ControladorEstabelecimento controladorEstabelecimento) {
        this.controladorEstabelecimento = controladorEstabelecimento;
    }

    public void setControladorRelatorio(ControladorRelatorio controladorRelatorio) {
        this.controladorRelatorio = controladorRelatorio;
    }

    public void abrirTelaItemAdicionar() {
        telaItem.setModoEdicao(false);
        telaItem.setVisible(true);
    }
    
    public void abrirTelaItemEditar(int indiceSelecionado) {
        telaItem.setModoEdicao(true);
        telaItem.setIndiceItemSelecionado(indiceSelecionado);
        ItemCardapio itemEditar = this.getItem(indiceSelecionado);
        telaItem.setItemEditavel(itemEditar.getDescricao(), itemEditar.isExigePreparo());
        telaItem.setVisible(true);
    }

    public void adicionarItemCardapio(String descricao, boolean exigePreparo) {
        //OBS: O status do item começa com NULL antes de ser enviado a cozinha
        ItemCardapio item = new ItemCardapio(descricao, exigePreparo, null);     
        Estabelecimento.getInstance().getCardapio().inserirItemNoCardapio(item);
        controladorPrincipal.salvarNoDisco();
        atualizarCardapioNaTela();
    }

    public boolean JaPossuiItemComEsteNomeNoCardapio(String nome) {
        return Estabelecimento.getInstance().getCardapio().jaPossuiItemCom(nome);
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
        telaCardapio.setarModeloLista(modelCardapio);
    } 

    public void editarItem(int indiceItemSelecionado, String nome, boolean exigePreparo) {
        Estabelecimento.getInstance().getCardapio().editarItem(indiceItemSelecionado, nome, exigePreparo);
        controladorPrincipal.salvarNoDisco();
        this.atualizarCardapioNaTela();
    }

    public void removerItem(int posicao) {
        Estabelecimento.getInstance().getCardapio().removerItemNa(posicao);
        controladorPrincipal.salvarNoDisco();
        this.atualizarCardapioNaTela();
    }
    
    public ItemCardapio getItem(int posicao){
        return Estabelecimento.getInstance().getCardapio().pegarItem(posicao);
    }
}
