package jogo;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class DealerPanel1 extends javax.swing.JPanel {

    protected JogadorInterface player;
    private CardLabel cardLabel;

    public DealerPanel1(JogadorInterface player) {
        initComponents();
        this.player = player;
        nomeJog.setText("Dealer");

    }

    public void cleanPanel() {
        this.panelDealer.removeAll();
        revalidate();
        repaint();
    }

    public void carregarDealer(JogadorInterface p) {
        panelDealer.removeAll();
        this.player = p;
        try {
            if (player != null) {
                jogada(player.getMao(0));
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void drawBlackjackDealer(String c1, int local) {
        cardLabel = new CardLabel();
        cardLabel.setCardImage(c1);
        cardLabel.setCardCovered(false);
        cardLabel.setLocation(local, 20);
        this.panelDealer.add(cardLabel);
        repaint();
    }

    public void jogada(MaoInterface hand) throws RemoteException {
        panelDealer.removeAll();
        String content = "";
        int local = 20;
        if (hand != null) {
            ArrayList<int[]> list = hand.getCardsIntArray();
            for (int i = 0; i < list.size(); i++) {
                drawBlackjackDealer(intArrayToString(list.get(i)), local);
                local += 80;
            }
        }
    }

    public static String intArrayToString(int[] array) {
        if (array[0] == -1 && array[1] == -1) {
            return "bv";
        } else {
            String suitString;
            switch (array[0]) {
                case 1:
                    suitString = "h";
                    break;
                case 2:
                    suitString = "d";
                    break;
                case 3:
                    suitString = "c";
                    break;
                default:
                    suitString = "s";
            }

            String valueString;
            switch (array[1]) {
                case 0:
                    valueString = "";
                case 1:
                    valueString = "1";
                    break;
                case 11:
                    valueString = "j";
                    break;
                case 12:
                    valueString = "q";
                    break;
                case 13:
                    valueString = "k";
                    break;
                default:
                    valueString = array[1] + "";
            }
            return suitString + "" + valueString;
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeJog = new javax.swing.JLabel();
        panelDealer = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 153, 0));

        nomeJog.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nomeJog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomeJog.setText("Dealer");

        panelDealer.setBackground(new java.awt.Color(0, 153, 0));

        javax.swing.GroupLayout panelDealerLayout = new javax.swing.GroupLayout(panelDealer);
        panelDealer.setLayout(panelDealerLayout);
        panelDealerLayout.setHorizontalGroup(
            panelDealerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );
        panelDealerLayout.setVerticalGroup(
            panelDealerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 267, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDealer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(nomeJog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nomeJog)
                .addGap(18, 18, 18)
                .addComponent(panelDealer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel nomeJog;
    private javax.swing.JPanel panelDealer;
    // End of variables declaration//GEN-END:variables
}