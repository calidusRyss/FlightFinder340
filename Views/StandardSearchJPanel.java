/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.FlightFinder340.Views;

import flightfinder3.main.java.FlightFinder340.Views.StandardSearchCollector;
import flightfinder3.main.java.FlightFinder340.Views.StandardSearchView;
import main.java.models.flightapi.enums.StoreSortMode;

/**
 *
 * @author Callidus
 */
public class StandardSearchJPanel extends javax.swing.JPanel {

    /**
     * Creates new form StandardSearchJPanel
     */
    public StandardSearchJPanel() {
        initComponents();
        
        inilize();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jButton3 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jpanel10 = new javax.swing.JPanel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jpanel9 = new javax.swing.JPanel();
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
        jLabel130 = new javax.swing.JLabel();
        jpanel11 = new javax.swing.JPanel();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jpanel12 = new javax.swing.JPanel();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        timePicker1 = new com.github.lgooddatepicker.components.TimePicker();
        datePicker2 = new com.github.lgooddatepicker.components.DatePicker();
        jPanel11 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        timePicker3 = new com.github.lgooddatepicker.components.TimePicker();
        datePicker3 = new com.github.lgooddatepicker.components.DatePicker();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");
        jPopupMenu1.add(jMenuItem1);

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField1.setText("CLT");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
        });

        jTextField3.setText("US");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel52.setText("Flying from");

        jLabel51.setText("Flying To");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel51)
                .addGap(50, 50, 50))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setPreferredSize(new java.awt.Dimension(559, 834));
        jPanel3.setEnabled(false);
        jPanel3.setOpaque(false);

        jpanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel131.setText("Origin");
        jLabel131.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jpanel10.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 38, 90, -1));

        jLabel132.setText("originDepartureTime");
        jLabel132.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jpanel10.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 85, -1, -1));

        jLabel133.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel133.setText("originFlightCarrier");
        jpanel10.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 105, -1, -1));

        jLabel134.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel134.setText("destination");
        jLabel134.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jpanel10.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 38, 210, -1));

        jLabel135.setText("inboundDepartureTime");
        jLabel135.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jpanel10.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 85, -1, -1));

        jLabel136.setText("inboundFlightCarrier");
        jLabel136.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jpanel10.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 105, -1, -1));

        jLabel137.setText("price");
        jLabel137.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jpanel10.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, -1, -1));

        jLabel138.setText("index");
        jpanel10.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

        jLabel139.setText("From:");
        jpanel10.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 13, -1, -1));

        jLabel140.setText(" To");
        jpanel10.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 13, -1, -1));

        jLabel141.setText("Out Going Take off time ");
        jpanel10.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 60, -1, -1));

        jLabel142.setText("Out Going Take off time ");
        jpanel10.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 60, -1, -1));

        jpanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel119.setText("Origin");
        jLabel119.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jpanel9.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 38, 90, -1));

        jLabel120.setText("originDepartureTime");
        jLabel120.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jpanel9.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 85, -1, -1));

        jLabel121.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel121.setText("originFlightCarrier");
        jpanel9.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 105, -1, -1));

        jLabel122.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel122.setText("destination");
        jLabel122.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jpanel9.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 38, 210, -1));

        jLabel123.setText("inboundDepartureTime");
        jLabel123.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jpanel9.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 85, -1, -1));

        jLabel124.setText("inboundFlightCarrier");
        jLabel124.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jpanel9.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 105, -1, -1));

        jLabel125.setText("price");
        jLabel125.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jpanel9.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, -1, -1));

        jLabel126.setText("index");
        jpanel9.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

        jLabel127.setText("From:");
        jpanel9.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 13, -1, -1));

        jLabel128.setText(" To");
        jpanel9.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 13, -1, -1));

        jLabel129.setText("Out Going Take off time ");
        jpanel9.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 60, -1, -1));

        jLabel130.setText("Out Going Take off time ");
        jpanel9.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 60, -1, -1));

        jpanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel143.setText("Origin");
        jLabel143.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jpanel11.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 38, 90, -1));

        jLabel144.setText("originDepartureTime");
        jLabel144.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jpanel11.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 85, -1, -1));

        jLabel145.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel145.setText("originFlightCarrier");
        jpanel11.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 105, -1, -1));

        jLabel146.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel146.setText("destination");
        jLabel146.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jpanel11.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 38, 210, -1));

        jLabel147.setText("inboundDepartureTime");
        jLabel147.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jpanel11.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 85, -1, -1));

        jLabel148.setText("inboundFlightCarrier");
        jLabel148.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jpanel11.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 105, -1, -1));

        jLabel149.setText("price");
        jLabel149.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jpanel11.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, -1, -1));

        jLabel150.setText("index");
        jpanel11.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

        jLabel151.setText("From:");
        jpanel11.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 13, -1, -1));

        jLabel152.setText(" To");
        jpanel11.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 13, -1, -1));

        jLabel153.setText("Out Going Take off time ");
        jpanel11.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 60, -1, -1));

        jLabel154.setText("Out Going Take off time ");
        jpanel11.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 60, -1, -1));

        jpanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel155.setText("Origin");
        jLabel155.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jpanel12.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 38, 90, -1));

        jLabel156.setText("originDepartureTime");
        jLabel156.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jpanel12.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 85, -1, -1));

        jLabel157.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel157.setText("originFlightCarrier");
        jpanel12.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 105, -1, -1));

        jLabel158.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel158.setText("destination");
        jLabel158.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jpanel12.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 38, 210, -1));

        jLabel159.setText("inboundDepartureTime");
        jLabel159.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jpanel12.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 85, -1, -1));

        jLabel160.setText("inboundFlightCarrier");
        jLabel160.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jpanel12.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 105, -1, -1));

        jLabel161.setText("price");
        jLabel161.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jpanel12.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, -1, -1));

        jLabel162.setText("index");
        jpanel12.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

        jLabel163.setText("From:");
        jpanel12.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 13, -1, -1));

        jLabel164.setText(" To");
        jpanel12.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 13, -1, -1));

        jLabel165.setText("Out Going Take off time ");
        jpanel12.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 60, -1, -1));

        jLabel166.setText("Out Going Take off time ");
        jpanel12.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 60, -1, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
            .addComponent(jpanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
            .addComponent(jpanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
            .addComponent(jpanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jpanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(333, 333, 333))
        );

        jLabel50.setText("Standard Search");
        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton2.setText("next");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(64, 64, 64))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Departing");

        timePicker1.setText("Choose Time");

        datePicker2.setText("Choose Date");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(timePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(datePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(datePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(timePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel53.setText("Returning");

        timePicker3.setText("Choose Time");

        datePicker3.setText("Choose Date");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel53)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(timePicker3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(datePicker3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel53)
                .addGap(1, 1, 1)
                .addComponent(datePicker3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(timePicker3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 18, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setMinimumSize(new java.awt.Dimension(155, 20));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Sort By");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel50)
                                .addGap(77, 77, 77))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                        .addComponent(jButton3)
                                        .addGap(92, 92, 92))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel50)
                .addGap(27, 27, 27)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // SearchButton
        this.view.setFlightResults();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.view.setAllFlightBoxsNext();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.view.setAllFlightBoxsBack();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        // TODO add your handling code here:
        //jPopupMenu1.show(this, jTextField1.getBaseline(), HEIGHT) , jTextField1.getY());
    }//GEN-LAST:event_jTextField1FocusGained

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        view.setSortMode(jComboBox1.getSelectedIndex());
    }//GEN-LAST:event_jComboBox1ActionPerformed

     public  void inilize()
    {
       // This helper method is used because the componets passed below can not be referenced from a static context.
       StandardSearchCollector ssc = new StandardSearchCollector( 
               this.jTextField1,
               this.jTextField3,
               this.datePicker2,
               this.datePicker3,
               this.timePicker1,
               this.timePicker3);
       this.view = new StandardSearchView(ssc,this.jPanel3);   
       
       view.loadSortModes(jComboBox1,StoreSortMode.CHEAPEST);
    }   
    
   
    private StandardSearchView view;
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DatePicker datePicker2;
    private com.github.lgooddatepicker.components.DatePicker datePicker3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel jpanel10;
    private javax.swing.JPanel jpanel11;
    private javax.swing.JPanel jpanel12;
    private javax.swing.JPanel jpanel9;
    private com.github.lgooddatepicker.components.TimePicker timePicker1;
    private com.github.lgooddatepicker.components.TimePicker timePicker3;
    // End of variables declaration//GEN-END:variables
}
