/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import jogo.JogadorInterface;
import jogo.GerirInterface;

/**
 *
 * @author Fabio
 */
public class MainFrame extends javax.swing.JFrame {

    private JogadorInterface me;
    private GerirInterface session;

    private ArrayList<PanelJogador> playerPanels;
    private DealerPanel1 dealerPanel;

    /**
     * Creates new form MainFrame1
     */
    public MainFrame(JogadorInterface player, GerirInterface session) {
        initComponents();
        this.setSize(1700, 1045);

        me = player;
        this.session = session;

        playerPanels = new ArrayList<PanelJogador>();

        messageBox.setSize(390, 175);
        draw();
        refresh(session, "");
        fecharJanela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TablePanel = new javax.swing.JPanel();
        btnHit = new javax.swing.JButton();
        btnStand = new javax.swing.JButton();
        PanelJogadores = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();
        pDealer = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageBox = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TablePanel.setBackground(new java.awt.Color(0, 153, 0));
        TablePanel.setMaximumSize(null);

        btnHit.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnHit.setText("Hit");
        btnHit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitActionPerformed(evt);
            }
        });

        btnStand.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnStand.setText("Stand");
        btnStand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStandActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelJogadoresLayout = new javax.swing.GroupLayout(PanelJogadores);
        PanelJogadores.setLayout(PanelJogadoresLayout);
        PanelJogadoresLayout.setHorizontalGroup(
            PanelJogadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1229, Short.MAX_VALUE)
        );
        PanelJogadoresLayout.setVerticalGroup(
            PanelJogadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 304, Short.MAX_VALUE)
        );

        btnStart.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pDealerLayout = new javax.swing.GroupLayout(pDealer);
        pDealer.setLayout(pDealerLayout);
        pDealerLayout.setHorizontalGroup(
            pDealerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 681, Short.MAX_VALUE)
        );
        pDealerLayout.setVerticalGroup(
            pDealerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );

        messageBox.setColumns(20);
        messageBox.setRows(5);
        jScrollPane1.setViewportView(messageBox);

        javax.swing.GroupLayout TablePanelLayout = new javax.swing.GroupLayout(TablePanel);
        TablePanel.setLayout(TablePanelLayout);
        TablePanelLayout.setHorizontalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TablePanelLayout.createSequentialGroup()
                .addGroup(TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TablePanelLayout.createSequentialGroup()
                        .addGap(465, 465, 465)
                        .addComponent(pDealer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TablePanelLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(PanelJogadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(295, Short.MAX_VALUE))
            .addGroup(TablePanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnHit, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnStand, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        TablePanelLayout.setVerticalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pDealer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(PanelJogadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addGroup(TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnHit)
                        .addComponent(btnStart)
                        .addComponent(btnStand))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitActionPerformed
        // TODO add your handling code here:
        try {
            me.hit();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnHitActionPerformed

    private void btnStandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStandActionPerformed
        // TODO add your handling code here:
        try {
            me.stand();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnStandActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        // TODO add your handling code here:
        try {
            if (me.getQuantia() <= 0) {
                JOptionPane.showMessageDialog(this, "Nao tem fichas para jogar, o jogo vai fechar.");
                me.desconectado();
                System.exit(0);

            } else {
                me.start(2);
                dealerPanel.carregarDealer(session.getDealer());
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnStartActionPerformed

    protected void fecharJanela() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    System.out.println("sair");
                    me.desconectado();
                    System.exit(0);
                } catch (RemoteException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public DealerPanel1 getDealerPanel() {
        return dealerPanel;
    }

    public void refresh(GerirInterface session, String message) {
        try {

            if(me.isMinhaVez()){
                btnHit.setEnabled(true);
                btnStand.setEnabled(true);
            } else {
                 btnHit.setEnabled(false);
                btnStand.setEnabled(false);
            }
            dealerPanel.carregarDealer(session.getDealer());
            for (int i = 0; i < playerPanels.size(); i++) {
                playerPanels.get(i).loadFromPlayer(session.getJogadores()[i]);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        messageBox.append(message + "\n");
    }

    public void draw() {
        try {
            pDealer.setLayout(new BorderLayout());
            dealerPanel = new DealerPanel1(session.getDealer());
            pDealer.add(dealerPanel);

            JogadorInterface[] players = session.getJogadores();

            PanelJogadores.setLayout(new GridLayout(1, 3));

            if (players != null) {

                for (int i = 0; i < players.length; i++) {

                    PanelJogador ppt = new PanelJogador(players[i]);
                    playerPanels.add(ppt);
                    PanelJogadores.add(ppt);
                }
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        }
//		this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelJogadores;
    private javax.swing.JPanel TablePanel;
    private javax.swing.JButton btnHit;
    private javax.swing.JButton btnStand;
    private javax.swing.JButton btnStart;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea messageBox;
    private javax.swing.JPanel pDealer;
    // End of variables declaration//GEN-END:variables
}
