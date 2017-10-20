
package atendimento.model;

import gerencia.model.ItemCardapio;
import java.util.ArrayList;

public class Comanda {
    
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


    
}
