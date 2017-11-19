
package gerencia.model;

import java.io.Serializable;

public class ItemCardapio implements Serializable {
    
    private String descricao;
    private boolean exigePreparo;
    private StatusItem status;
    
    public ItemCardapio(String descricao, boolean exigePreparo, StatusItem status){
        this.descricao = descricao;
        this.exigePreparo = exigePreparo;
        this.status = status;
    }
    
    public ItemCardapio(ItemCardapio copia){
        this.descricao = copia.descricao;
        this.exigePreparo = copia.exigePreparo;
        this.status = copia.status;
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
    
    public String getDescricaoStatus() {
        if(this.status != null){
            switch (this.status) {
            case CANCELADO:
                return "Cancelado";
            case EM_ESPERA:
                return "Em espera";
            case EM_PREPARO:
                return "Em preparo";
            case ENTREGUE:
                return "Entregue";
            case PRONTO:
                return "Pronto";
            }
        } else {
            return "Sem status";
        }
        return "Sem status";
    } 

    public String getProximoStatus() {
        if(this.status != null){
            if (this.exigePreparo) {
                switch (this.status) {
                    case CANCELADO:
                    return "Desabilitar";
                    case EM_ESPERA:
                    return "Em preparo";
                    case EM_PREPARO:
                    return "Pronto";
                    case ENTREGUE:
                    return "Desabilitar";
                    case PRONTO:
                    return "Entregue";
                }
            } else {
                if (this.status == StatusItem.PRONTO) {
                    return "Entregue";
                } else if (this.status == StatusItem.ENTREGUE){
                    return "Desabilitar";
                }
            }
        }
        return "Desabilitar";
    }

    public void avancarStatus() {
        if(this.status != null){
            switch (this.status) {
            case CANCELADO:
                break;
            case EM_ESPERA:
                this.setStatus(StatusItem.EM_PREPARO);
                break;
            case EM_PREPARO:
                this.setStatus(StatusItem.PRONTO);
                break;
            case ENTREGUE:
                break;
            case PRONTO:
                this.setStatus(StatusItem.ENTREGUE);
                break;
            }
        }
    }
    
    public void cancelar(){
        this.setStatus(StatusItem.CANCELADO);
    }
}
