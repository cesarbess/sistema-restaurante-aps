
package gerencia.controller;

import atendimento.controller.ControladorMesas;
import gerencia.view.TelaEstabelecimento;
import gerencia.view.TelaInicial;

public class ControladorInicial {
    
    private TelaInicial telaInicial;
    private ControladorEstabelecimento controladorEstabelecimento;
    private ControladorMesas controladorMesas;
    
    public ControladorInicial(TelaInicial telaInicial){
        this.telaInicial = telaInicial;
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
        controladorEstabelecimento = new ControladorEstabelecimento();
        controladorEstabelecimento.abrirTela();
    }

    public void abrirTela() {
        this.telaInicial.setVisible(true);
    }

    public void entrarTelaAtendimento() {
        controladorMesas = new ControladorMesas();
        controladorMesas.abrirTela();
    }
}
