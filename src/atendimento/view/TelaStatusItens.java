
package atendimento.view;

import atendimento.controller.ControladorComandas;
import gerencia.model.TipoPerfil;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TelaStatusItens extends javax.swing.JFrame {

    private ControladorComandas owner;
    private Integer idMesa;
    
    public TelaStatusItens(ControladorComandas owner) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.owner = owner;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaItens = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        btnAvancarStatus = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        btnCancelarPedido = new javax.swing.JButton();

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Itens da comanda");

        listaItens.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "File Mignon", "Coca-Cola" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaItens);

        jLabel2.setText("Status:");

        btnAvancarStatus.setText("Marcar como pronto");
        btnAvancarStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvancarStatusActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnCancelarPedido.setText("Cancelar pedido");
        btnCancelarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnAvancarStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnAvancarStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelarPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSair)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.listaItens.clearSelection();
        this.statusLabel.setText("");
        this.setVisible(false);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnAvancarStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancarStatusActionPerformed
        if(listaItens.isSelectionEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Selecione um item primeiro");
        } else {
            owner.avancarStatusItem(listaItens.getSelectedValue(), idMesa);
        }
    }//GEN-LAST:event_btnAvancarStatusActionPerformed

    private void btnCancelarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPedidoActionPerformed
        if(listaItens.isSelectionEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Selecione um item primeiro");
        } else {
            owner.cancelarItem(listaItens.getSelectedValue(), idMesa);
        }
    }//GEN-LAST:event_btnCancelarPedidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvancarStatus;
    private javax.swing.JButton btnCancelarPedido;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaItens;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables

    public Integer getIdMesa(){
        return this.idMesa;
    }
    
    public void setIdMesa(Integer idMesa){
        this.idMesa = idMesa;
    }

    public void setarModeloLista(DefaultListModel model){
        this.listaItens.setModel(model);
        listaItens.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
            if (!evt.getValueIsAdjusting()) {
                if (listaItens.getSelectedValue() != null){
                    owner.atualizarTelaParaItem(listaItens.getSelectedValue(), idMesa);
                }
            }
        }
        });
    }

    public void atualizarTelaParaStatus(String descricaoStatus, String proximoStatus) {
        this.statusLabel.setText(descricaoStatus);
        if(proximoStatus.equals("Desabilitar")){
            this.btnAvancarStatus.setEnabled(false);
        } else {
            this.btnAvancarStatus.setEnabled(true);
            this.btnAvancarStatus.setText("Marcar como " + proximoStatus);
        }
    }

    public void mostrarAvisoParaPerfilInvalido(TipoPerfil perfilEmUso, String nomeStatus) {
        if(perfilEmUso == TipoPerfil.GARCOM) {
            JOptionPane.showMessageDialog(rootPane, "Apenas o Cozinheiro pode marcar o status como: " +nomeStatus);
        } else if (perfilEmUso == TipoPerfil.COZINHEIRO) {
            JOptionPane.showMessageDialog(rootPane, "Apenas o Garçom pode marcar o status como: " +nomeStatus);
        }
    }
}
