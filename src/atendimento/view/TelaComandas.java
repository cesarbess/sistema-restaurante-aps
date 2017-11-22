
package atendimento.view;

import atendimento.controller.ControladorComandas;
import gerencia.model.TipoPerfil;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TelaComandas extends javax.swing.JFrame {
    
    private ControladorComandas owner;
    
    public TelaComandas(ControladorComandas owner) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.owner = owner;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnMesas = new javax.swing.JButton();
        btnComandas = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaComandas = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        trocarStatusBtn = new javax.swing.JButton();
        trocarMesaBtn = new javax.swing.JButton();
        enviarCozinhaBtn = new javax.swing.JButton();
        sairBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Garçom"));

        btnMesas.setText("Mesas");
        btnMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesasActionPerformed(evt);
            }
        });

        btnComandas.setText("Comandas");
        btnComandas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComandasActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Comandas"));

        jScrollPane1.setViewportView(listaComandas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Opções\n"));

        trocarStatusBtn.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        trocarStatusBtn.setText("Trocar Status");
        trocarStatusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trocarStatusBtnActionPerformed(evt);
            }
        });

        trocarMesaBtn.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        trocarMesaBtn.setText("Trocar Mesa");
        trocarMesaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trocarMesaBtnActionPerformed(evt);
            }
        });

        enviarCozinhaBtn.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        enviarCozinhaBtn.setText("Enviar a cozinha");
        enviarCozinhaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarCozinhaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(enviarCozinhaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trocarStatusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trocarMesaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(enviarCozinhaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(trocarStatusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(trocarMesaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        sairBtn.setText("Sair");
        sairBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnComandas, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sairBtn)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnComandas, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(sairBtn))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesasActionPerformed
        owner.abrirTelaMesas();
    }//GEN-LAST:event_btnMesasActionPerformed

    private void btnComandasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComandasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnComandasActionPerformed

    private void sairBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairBtnActionPerformed
        this.owner.sair();
    }//GEN-LAST:event_sairBtnActionPerformed

    private void trocarMesaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trocarMesaBtnActionPerformed
        if(owner.ehGarcom()) {
            if(listaComandas.isSelectionEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Selecione uma comanda para trocar a mesa");
            } else {
                owner.abrirTelaTrocarMesa();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Apenas o garçom pode trocar a mesa da comanda");
        }
    }//GEN-LAST:event_trocarMesaBtnActionPerformed

    private void enviarCozinhaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarCozinhaBtnActionPerformed
        if(owner.ehGarcom()) {
            if(listaComandas.isSelectionEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Selecione uma comanda para enviar a cozinha");
            } else {
                Integer numeroMesaSelecionada = getIdComandaSelecionada();
                if(owner.comandaPossuiItemQueExigePreparo(numeroMesaSelecionada)){
                    if (owner.enviarComandaACozinha(numeroMesaSelecionada)){
                      trocarStatusBtn.setEnabled(true);
                      JOptionPane.showMessageDialog(rootPane, "Os itens pendentes da comanda foram enviados a cozinha");
                    } else {
                      JOptionPane.showMessageDialog(rootPane, "A comanda não tem nenhum item pendente a ser enviado a cozinha");
                    }
                } else {
                JOptionPane.showMessageDialog(rootPane, "A comanda não tem nenhum item que exige preparo");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Apenas o garçom pode enviar itens a cozinha");
        }
    }//GEN-LAST:event_enviarCozinhaBtnActionPerformed

    private void trocarStatusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trocarStatusBtnActionPerformed
        if(listaComandas.isSelectionEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Selecione uma comanda para trocar o status dos itens");
        } else {
            Integer numeroMesaSelecionada = getIdComandaSelecionada();
            owner.abrirTelaStatusItens(numeroMesaSelecionada);
        }
    }//GEN-LAST:event_trocarStatusBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComandas;
    private javax.swing.JButton btnMesas;
    private javax.swing.JButton enviarCozinhaBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaComandas;
    private javax.swing.JButton sairBtn;
    private javax.swing.JButton trocarMesaBtn;
    private javax.swing.JButton trocarStatusBtn;
    // End of variables declaration//GEN-END:variables

    public void setarModeloLista(DefaultListModel model){
        this.listaComandas.setModel(model);
        listaComandas.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
            if (!evt.getValueIsAdjusting()) {
                if (listaComandas.getSelectedValue() != null){
                    boolean habilitarTrocaStatus = owner.comandaFoiEnviadaACozinha(getIdComandaSelecionada());
                    if(habilitarTrocaStatus) {
                        trocarStatusBtn.setEnabled(true);
                    } else {
                        trocarStatusBtn.setEnabled(false);
                    }
                }
            }
        }
        });
    }
    
    public Integer getIdComandaSelecionada(){
        String comandaSelecionada = listaComandas.getSelectedValue();
        if(comandaSelecionada.length()==18) {
            return Integer.parseInt(comandaSelecionada.substring(comandaSelecionada.length() -1));
        } else {
            return Integer.parseInt(comandaSelecionada.substring(comandaSelecionada.length() -2));
        }
    }
    
    public void configurarTelaParaPerfil(TipoPerfil perfilEmUso) {
        if (perfilEmUso == TipoPerfil.COZINHEIRO){
            btnComandas.setLayout(btnMesas.getLayout());
            btnMesas.setVisible(false);
            btnMesas.setEnabled(false);
        }
    }
}
