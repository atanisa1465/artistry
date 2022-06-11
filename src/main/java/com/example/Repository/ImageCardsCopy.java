package com.example.Repository;

import java.awt.Dimension;


public class ImageCardsCopy extends ImageCards{


    public ImageCardsCopy() {
        super();
        initComponents();
    }
                       
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(245,254,255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        this.setPreferredSize(new Dimension(234, 338));

        jLabel1.setPreferredSize(new Dimension(220, 244));
        //jLabel1.setText("Demo");
        jButton2.setText("Download");
        jButton3.setText("Delete");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        this.setOpaque(true);
        this.setVisible(false);
    }

    //     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    //     this.setLayout(layout);
    //     layout.setHorizontalGroup(
    //         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    //         .addGroup(layout.createSequentialGroup()
    //             .addContainerGap()
    //             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    //                 .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    //                 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
    //                     .addGap(0, 0, Short.MAX_VALUE)
    //                     .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
    //                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
    //                     .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
    //                 .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    //             .addContainerGap())
    //     );
    //     layout.setVerticalGroup(
    //         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    //         .addGroup(layout.createSequentialGroup()
    //             .addContainerGap()
    //             .addComponent(jLabel1, 244, 244, 244)
    //             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
    //             .addComponent(jButton1)
    //             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
    //             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
    //                 .addComponent(jButton2)
    //                 .addComponent(jButton3))
    //             .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    //     );
    // }                    

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
}