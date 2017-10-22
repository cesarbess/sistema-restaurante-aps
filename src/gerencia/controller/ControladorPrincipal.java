
package gerencia.controller;

import atendimento.controller.ControladorComandas;
import atendimento.controller.ControladorMesas;
import gerencia.model.Estabelecimento;
import gerencia.view.TelaEscolhaPerfil;
import gerencia.view.TelaInicial;
import gerencia.model.TipoPerfil;

public class ControladorPrincipal {
    
    private TelaInicial telaInicial;
    private TelaEscolhaPerfil telaEscolhaPerfil;
    private ControladorEstabelecimento controladorEstabelecimento;
    private ControladorMesas controladorMesas;
    private ControladorComandas controladorComandas;
    
    public ControladorPrincipal(TelaInicial telaInicial){
        this.telaInicial = telaInicial;
        this.telaEscolhaPerfil = new TelaEscolhaPerfil(this);
    }
    
        public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    public void entrarTelaGerencia() {
        if (controladorEstabelecimento == null){
            controladorEstabelecimento = new ControladorEstabelecimento(this);
        }
        telaInicial.setVisible(false);
        controladorEstabelecimento.abrirTela();
    }

    public void abrirTela() {
        this.telaInicial.setVisible(true);
    }

    public void entrarTelaAtendimento() {
        if (!Estabelecimento.foiConfigurado()) {
            telaInicial.mostrarAvisoConfEstabelecimento();
            return;
        } else if(Estabelecimento.foiConfigurado() && (Estabelecimento.getInstance().getCardapio() == null || Estabelecimento.getInstance().getCardapio().getItens().isEmpty())){
            telaInicial.mostrarAvisoCardapioNaoConfigurado();
            return;
        } else {
            abrirTelaEscolhaPerfil();
        }
    }

    public void escolherPerfil(TipoPerfil tipo) {
        Estabelecimento.getInstance().setPerfilEmUso(tipo);
        abrirTelaParaPerfilEscolhido(tipo);
    }   

    private void abrirTelaEscolhaPerfil() {
        this.telaEscolhaPerfil.setVisible(true);
    }

    private void abrirTelaParaPerfilEscolhido(TipoPerfil perfilEmUso) {
        if (perfilEmUso == TipoPerfil.GARCOM){
            controladorMesas = new ControladorMesas(this);
            telaInicial.setVisible(false);
            telaEscolhaPerfil.setVisible(false);
            controladorMesas.abrirTela();
        } else{
            controladorComandas = new ControladorComandas(this);
            telaInicial.setVisible(false);
            telaEscolhaPerfil.setVisible(false);
            controladorComandas.abrirTela();
        } 
    }
}
