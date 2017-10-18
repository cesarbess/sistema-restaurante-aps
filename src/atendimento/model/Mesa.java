
package atendimento.model;

public class Mesa {
    private boolean estaLivre;
    private Integer id;

    public Mesa(Integer id, boolean estaLivre){
        this.id = id;
        this.estaLivre = estaLivre;
    }
    
    public Mesa(Integer id){
        this.id = id;
        this.estaLivre = true;
    }

    public boolean isEstaLivre() {
        return estaLivre;
    }

    public void setEstaLivre(boolean estaLivre) {
        this.estaLivre = estaLivre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
