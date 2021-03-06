
package atendimento.view;

import atendimento.controller.ControladorMesas;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class TelaMesas extends javax.swing.JFrame {

    private ControladorMesas owner;
    private ArrayList<JButton> botoesMesa;
    private ArrayList<Integer> mesasOcupadas;
    
    public TelaMesas(ControladorMesas owner, int numeroMesas, ArrayList<Integer> mesasOcupadas) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.owner = owner;
        this.mesasOcupadas = mesasOcupadas;
        botoesMesa = new ArrayList<>();
        int linhas = Math.round(numeroMesas/3);
        GridLayout layout = new GridLayout(linhas, 3);
        mesasPanel.setLayout(layout);
        inicializarMesas(numeroMesas);
        
        //Começa com a mesa 1 selecionada
        mesaSelecionadaLabel.setName("1");
        if(mesasOcupadas.contains(1)){
            btnEstadoMesa.setText("Liberar Mesa");
            btnCriarComanda.setText("Editar Comanda");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnMesas = new javax.swing.JButton();
        btnComandas = new javax.swing.JButton();
        mesasPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnCriarComanda = new javax.swing.JButton();
        btnEstadoMesa = new javax.swing.JButton();
        btnCancelarComanda = new javax.swing.JButton();
        mesaSelecionadaLabel = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();

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

        mesasPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Mesas"));

        javax.swing.GroupLayout mesasPanelLayout = new javax.swing.GroupLayout(mesasPanel);
        mesasPanel.setLayout(mesasPanelLayout);
        mesasPanelLayout.setHorizontalGroup(
            mesasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );
        mesasPanelLayout.setVerticalGroup(
            mesasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Opções\n"));

        btnCriarComanda.setText("Criar Comanda");
        btnCriarComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarComandaActionPerformed(evt);
            }
        });

        btnEstadoMesa.setText("Ocupar Mesa");
        btnEstadoMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoMesaActionPerformed(evt);
            }
        });

        btnCancelarComanda.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        btnCancelarComanda.setText("Cancelar Comanda");
        btnCancelarComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarComandaActionPerformed(evt);
            }
        });

        mesaSelecionadaLabel.setText("Mesa 1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEstadoMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCriarComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelarComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(mesaSelecionadaLabel)
                        .addGap(80, 80, 80))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(mesaSelecionadaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEstadoMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCriarComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelarComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mesasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnComandas, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSair)
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
                    .addComponent(btnSair))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesasPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        // TODO add youmesasPaneling code here:
    }//GEN-LAST:event_btnMesasActionPerformed

    private void btnComandasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComandasActionPerformed
        this.owner.abrirTelaComandas();
    }//GEN-LAST:event_btnComandasActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.owner.sair();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnEstadoMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoMesaActionPerformed
        if(owner.isMesaLivre(Integer.parseInt(mesaSelecionadaLabel.getName()))){
            boolean sucesso = owner.ocuparMesa(Integer.parseInt(mesaSelecionadaLabel.getName()));
            if (sucesso){
               alterarCorBotaoMesa(mesaSelecionadaLabel.getName(), true);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível localizar a mesa");
            }
        } else {
            boolean sucesso = owner.liberarMesa(Integer.parseInt(mesaSelecionadaLabel.getName()));
            if (sucesso){
                alterarCorBotaoMesa(mesaSelecionadaLabel.getName(), false);
                btnCriarComanda.setText("Criar Comanda");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível liberar a mesa, certifique-se de que a comanda não possui nenhum item pendente na cozinha");
            }
        }
    }//GEN-LAST:event_btnEstadoMesaActionPerformed

    private void btnCriarComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarComandaActionPerformed
        boolean mesaPossuiComanda = owner.mesaPossuiComanda(getIdMesaSelecionada());
        boolean mesaEstaLivre = owner.isMesaLivre(getIdMesaSelecionada());
        if(!mesaPossuiComanda && mesaEstaLivre){
            JOptionPane.showMessageDialog(rootPane, "Você deve marcar esta mesa como Ocupada antes de criar uma comanda para ela");
        } else if(mesaPossuiComanda){
            owner.abrirTelaEdicaoComanda(getIdMesaSelecionada());
        } else {
            owner.abrirTelaCriarComanda();
        }
    }//GEN-LAST:event_btnCriarComandaActionPerformed

    private void btnCancelarComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarComandaActionPerformed
        boolean mesaPossuiComanda = owner.mesaPossuiComanda(getIdMesaSelecionada());
        if(mesaPossuiComanda){
            owner.cancelarComanda(getIdMesaSelecionada());
            btnCriarComanda.setText("Criar Comanda");
            JOptionPane.showMessageDialog(rootPane, "Comanda cancelada com sucesso");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Esta mesa não possui comanda");
        }
    }//GEN-LAST:event_btnCancelarComandaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarComanda;
    private javax.swing.JButton btnComandas;
    private javax.swing.JButton btnCriarComanda;
    private javax.swing.JButton btnEstadoMesa;
    private javax.swing.JButton btnMesas;
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel mesaSelecionadaLabel;
    private javax.swing.JPanel mesasPanel;
    // End of variables declaration//GEN-END:variables

    private void inicializarMesas(int numeroMesas) {
        for(int i = 0; i < numeroMesas; i++) {
            JButton button = new JButton("Mesa " + (i+1));
            button.setSize(113, 85);
            button.setBackground(Color.green);
            button.setName(new Integer(i+1).toString());
            if(mesasOcupadas.contains(i+1)){
                button.setBackground(Color.red);
            }
            
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton)e.getSource();
                    mesaSelecionadaLabel.setText(button.getText());
                    mesaSelecionadaLabel.setName(button.getName());
                    if(button.getBackground().equals(Color.red)){
                        btnEstadoMesa.setText("Liberar Mesa");
                    } else {
                        btnEstadoMesa.setText("Ocupar Mesa");
                    }
                    if(button.getBackground().equals(Color.red) && owner.mesaPossuiComanda(Integer.parseInt(button.getName()))){
                        setModoEdicao(true);
                    } else {
                        setModoEdicao(false);
                    }
                }
        });
            botoesMesa.add(button);
            mesasPanel.add(button);
        }
        mesasPanel.revalidate();
        mesasPanel.repaint();
    }
    
    public Integer getIdMesaSelecionada(){
        return Integer.parseInt(mesaSelecionadaLabel.getName());
    }
    
    public void alterarCorBotaoMesa(String idMesa, boolean ocupando){
        for(JButton button : botoesMesa){
            if(button.getName().equals(idMesa)){
                if(ocupando){
                    button.setBackground(Color.red);
                    btnEstadoMesa.setText("Liberar Mesa");
                } else {
                    button.setBackground(Color.green);
                    btnEstadoMesa.setText("Ocupar Mesa");
                }
            }
        }
    }
    
    public void setModoEdicao(boolean editando){
        if (editando){
            btnCriarComanda.setText("Editar Comanda");
        } else {
             btnCriarComanda.setText("Criar Comanda");
        }
    }
    
    public void setMesasOcupadas(ArrayList<Integer> mesasOcupadas){
        this.mesasOcupadas = mesasOcupadas;
    }
    
}
