package main.java.Views.JPanels;
/*
Last updated 11-27-2020.
Contributors-Michael
This is the AutoGenerated Jpanel for the  Flightbox or Quote displayPanel for Saved Quotes
Using the design tab in Netbeans to make changes is recommended.
*/

import main.java.Views.TripViewerView;
import main.java.controllers.ControllerBox;

/**
 *
 * @author Callidus
 */
public class TripFlightBoxJPanel extends javax.swing.JPanel {

    /**
     * Creates new form TripFlightBoxJPanel
     */
    public TripFlightBoxJPanel(TripViewerView _view) {
        view = _view;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel130 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel130.setText("\"Out Going Take off time\"");
        add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 60, -1, -1));

        jLabel119.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel119.setText("Origin");
        add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 38, 160, -1));

        jLabel120.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel120.setText("originDepartureTime");
        add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 85, -1, -1));

        jLabel121.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel121.setText("originFlightCarrier");
        add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 105, -1, -1));

        jLabel122.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel122.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel122.setText("destination");
        add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 210, -1));

        jLabel123.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel123.setText("inboundDepartureTime");
        add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 85, -1, -1));

        jLabel124.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel124.setText("inboundFlightCarrier");
        add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 105, -1, -1));

        jLabel125.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel125.setText("Price");
        add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 90, 30));

        jLabel126.setText("index");
        add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

        jLabel127.setText("\"From:\"");
        add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 13, -1, -1));

        jLabel128.setText("\" To\"");
        add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        jLabel129.setText("\"Out Going Take off time \"");
        add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 60, -1, -1));

        jButton1.setText("Delete From Trip");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int index = Integer.parseInt(jLabel126.getText()) -1;
        ControllerBox.getBox().getTripEditCont().removeQuoteAtIndexFromSelectedTrip(index);
        this.view.setFlightResults();
    }//GEN-LAST:event_jButton1ActionPerformed


    private TripViewerView view;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel130;
    // End of variables declaration//GEN-END:variables
}
