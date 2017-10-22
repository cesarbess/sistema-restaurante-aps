
package gerencia.view;

import gerencia.controller.ControladorPrincipal;
import gerencia.model.TipoPerfil;


public class TelaEscolhaPerfil extends javax.swing.JFrame {

    private ControladorPrincipal owner;

    public TelaEscolhaPerfil(ControladorPrincipal owner) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.owner = owner;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        garcomBtn = new javax.swing.JButton();
        cozinheiroBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Escolha seu perfil:");

        garcomBtn.setText("Garçom");
        garcomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                garcomBtnActionPerformed(evt);
            }
        });

        cozinheiroBtn.setText("Cozinheiro");
        cozinheiroBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cozinheiroBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(garcomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cozinheiroBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cozinheiroBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(garcomBtn)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cozinheiroBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cozinheiroBtnActionPerformed
        owner.escolherPerfil(TipoPerfil.COZINHEIRO);
    }//GEN-LAST:event_cozinheiroBtnActionPerformed

    private void garcomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_garcomBtnActionPerformed
        owner.escolherPerfil(TipoPerfil.GARCOM);
    }//GEN-LAST:event_garcomBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cozinheiroBtn;
    private javax.swing.JButton garcomBtn;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
