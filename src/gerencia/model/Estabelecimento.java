
package gerencia.model;

import atendimento.model.Comanda;
import atendimento.model.Mesa;
import java.util.ArrayList;

public class Estabelecimento {

    private String nome;
    private int quantidadeMesas;
    private Cardapio cardapio;
    private ArrayList<Mesa> mesas;
    private TipoPerfil perfilEmUso;
    private static Estabelecimento instancia;
    
    private Estabelecimento(){
        mesas = new ArrayList<>();
    }
    
    public static synchronized Estabelecimento getInstance(){
        if(instancia == null){
            instancia = new Estabelecimento();
        }
        return instancia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeMesas() {
        return quantidadeMesas;
    }

    public void setQuantidadeMesas(int quantidadeMesas) {
        this.quantidadeMesas = quantidadeMesas;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }
    
    public ArrayList<Mesa> getMesas() {
        return mesas;
    }
    
    public Mesa getMesaCom(Integer id){
        for(Mesa mesa : this.mesas){
            if(mesa.getId().equals(id)){
                return mesa;
            }
        }
        return null;
    }

    public void ocuparMesa(Integer idMesa, Comanda novaComanda) {
        Mesa mesa = getMesaCom(idMesa);
        mesa.setEstaLivre(false);
        mesa.setComanda(novaComanda);
        System.out.println("Setou a mesa com id: " + mesa.getId() + "para o status: ocupada com a comanda " + mesa.getComanda().getItensPedido());
    }

    public TipoPerfil getPerfilEmUso() {
        return perfilEmUso;
    }

    public void setPerfilEmUso(TipoPerfil perfilEmUso) {
        this.perfilEmUso = perfilEmUso;
    }
    
    public static boolean foiConfigurado(){
        return instancia != null;
    }
}
