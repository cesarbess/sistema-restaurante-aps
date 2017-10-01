
package gerencia.model;

public class ItemCardapio {
    
    private String descricao;
    private boolean exigePreparo;
    private StatusItem status;
    
    public ItemCardapio(String descricao, boolean exigePreparo, StatusItem status){
        this.descricao = descricao;
        this.exigePreparo = exigePreparo;
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isExigePreparo() {
        return exigePreparo;
    }

    public void setExigePreparo(boolean exigePreparo) {
        this.exigePreparo = exigePreparo;
    }

    public StatusItem getStatus() {
        return status;
    }

    public void setStatus(StatusItem status) {
        this.status = status;
    }
    
    
}
