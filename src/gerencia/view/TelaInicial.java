
package gerencia.view;

import gerencia.controller.ControladorPrincipal;
import javax.swing.JOptionPane;

public class TelaInicial extends javax.swing.JFrame {

    private ControladorPrincipal owner;
    
    public TelaInicial() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.owner = new ControladorPrincipal(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        gerenciaBtn = new javax.swing.JButton();
        atendimentoBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Bem Vindo"));

        gerenciaBtn.setText("Gerência");
        gerenciaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerenciaBtnActionPerformed(evt);
            }
        });

        atendimentoBtn.setText("Atendimento");
        atendimentoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atendimentoBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(atendimentoBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(gerenciaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {atendimentoBtn, gerenciaBtn});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gerenciaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(atendimentoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(208, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {atendimentoBtn, gerenciaBtn});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gerenciaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerenciaBtnActionPerformed
        String senhaDigitada = JOptionPane.showInputDialog("Digite a senha do Administrador: ");
        if(senhaDigitada == null){ return; }
        
        if (senhaDigitada.equals(owner.senha)){
            owner.entrarTelaGerencia();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Senha incorreta, contate o administrador do sistema");
        }
    }//GEN-LAST:event_gerenciaBtnActionPerformed

    private void atendimentoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atendimentoBtnActionPerformed
        owner.entrarTelaAtendimento();
    }//GEN-LAST:event_atendimentoBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atendimentoBtn;
    private javax.swing.JButton gerenciaBtn;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    public void mostrarAvisoConfEstabelecimento() {
        JOptionPane.showMessageDialog(rootPane, "É preciso configurar um Estabelecimento para continuar");
    }

    public void mostrarAvisoCardapioNaoConfigurado() {
        JOptionPane.showMessageDialog(rootPane, "Adicione pelo menos um item no cardápio para continuar");
    }
}
