
package gerencia.model;

public class Estabelecimento {

    private String nome;
    private int quantidadeMesas;
    
    public Estabelecimento(String nome, int quantidadeMesas) {
        this.nome = nome;
        this.quantidadeMesas = quantidadeMesas;
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
    
    
}