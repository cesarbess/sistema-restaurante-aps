
package gerencia.model;

import java.util.ArrayList;

public class Estabelecimento {

    private String nome;
    private int quantidadeMesas;
    private Cardapio cardapio;
    private ArrayList<Mesa> mesas;
    
    public Estabelecimento(String nome, int quantidadeMesas) {
        this.nome = nome;
        this.quantidadeMesas = quantidadeMesas;
        mesas = new ArrayList<>();
        for(int i = 0; i < quantidadeMesas; i++){
            Mesa mesa = new Mesa(i+1);
            mesas.add(mesa);
            System.out.println("Mesa com ID: " + mesa.getId() + "adicionada no array de mesas");
        }
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

}
