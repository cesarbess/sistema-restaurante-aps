
package atendimento.model;

import gerencia.model.ItemCardapio;
import gerencia.model.StatusItem;
import java.io.Serializable;
import java.util.ArrayList;

public class Comanda implements Serializable {
    
    private ArrayList<ItemCardapio> itensPedido;
    private Mesa mesa;
    
    public Comanda(Mesa mesa){
        this.mesa = mesa;
        this.itensPedido = new ArrayList<>();
    }

    public ArrayList<ItemCardapio> getItensPedido() {
        return itensPedido;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public void adicionarItemNaComanda(ItemCardapio itemCardapio) {
        itensPedido.add(itemCardapio);
    }

    public String getDescrição() {
        return "Comanda da mesa: " + this.mesa.getId();
    }

    public boolean possuiItemAtivoNaCozinha() {
        for(ItemCardapio item : this.itensPedido){
            if (item.getStatus() == StatusItem.EM_ESPERA || item.getStatus() == StatusItem.EM_PREPARO || item.getStatus() == StatusItem.PRONTO){
                return true;
            }
        }
        return false;
    }

    public boolean possuiItensQueExigePreparo() {
         for(ItemCardapio item : this.itensPedido){
             if(item.isExigePreparo()){
                 return true;
             }
         }
         return false;
    }

    public boolean possuiTodosItensEntregues() {
        for(ItemCardapio item : this.itensPedido){
             if(item.getStatus() != StatusItem.ENTREGUE){
                 return false;
             }
         }
         return true;
    }

    public boolean jaFoiEnviadaACozinha() {
        for(ItemCardapio item : this.itensPedido){
            if(item.getStatus() == null){
                return false;
            }
        }
        return true;
    }
}
