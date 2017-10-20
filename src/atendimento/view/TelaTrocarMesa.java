
package atendimento.view;

import atendimento.controller.ControladorComandas;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

public class TelaTrocarMesa extends javax.swing.JFrame {

    private ControladorComandas owner;
    
    public TelaTrocarMesa(ControladorComandas owner, int numeroMesas) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.owner = owner;
        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, numeroMesas, 1);
        numeroMesaSpinner.setModel(model);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        numeroMesaSpinner = new javax.swing.JSpinner();
        confirmarBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Numero da nova mesa:");

        confirmarBtn.setText("Confirmar");
        confirmarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarBtnActionPerformed(evt);
            }
        });

        cancelarBtn.setText("Cancelar");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(numeroMesaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(confirmarBtn)
                        .addGap(18, 18, 18)
                        .addComponent(cancelarBtn)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(numeroMesaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmarBtn)
                    .addComponent(cancelarBtn))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarBtnActionPerformed
        Integer novaMesa = (Integer) numeroMesaSpinner.getValue();
        if(owner.verificarSeMesaDisponivel(novaMesa)){
            owner.trocarMesaDaComanda(novaMesa);
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Esta mesa já esta ocupada, selecione outra por favor");
        }
    }//GEN-LAST:event_confirmarBtnActionPerformed

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelarBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JButton confirmarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSpinner numeroMesaSpinner;
    // End of variables declaration//GEN-END:variables

}
