
package gerencia.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cardapio implements Serializable {
    
    private ArrayList<ItemCardapio> itens;
    
    public Cardapio(){
        itens = new ArrayList<>();
    }
    
    public ArrayList<ItemCardapio> getItens() {
        return itens;
    }
    
    public void inserirItemNoCardapio(ItemCardapio item){
        if (!itens.contains(item)) {
            itens.add(item);
        }
    }    
    
    public boolean jaPossuiItemCom(String nome){
        for (ItemCardapio item : itens){
            if (item.getDescricao().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public void editarItem(int indiceItemSelecionado, String nome, boolean exigePreparo) {
        ItemCardapio itemEditar = itens.get(indiceItemSelecionado);
        itemEditar.setDescricao(nome);
        itemEditar.setExigePreparo(exigePreparo);
    }
    
    public void removerItemNa(int posicao){
        itens.remove(posicao);
    }

    public ItemCardapio pegarItem(int posicao) {
        return itens.get(posicao);
    }
}
