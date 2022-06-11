package com.example.Framework;

import javax.swing.*;
import java.awt.*;
// import java.awt.geom.*;

public class Frame extends javax.swing.JFrame {

    class ImagePanel extends JComponent {
        private Image image;
        public ImagePanel(Image image) {
            this.image = image;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    }
    
    
    int positionX = 0, positionY = 0;

    public Frame(JPanel p) {
        //setUndecorated(true);
        initComponents(p);
        setLocationRelativeTo(null);
        //setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),70,70));
    }
                      
    public void initComponents(JPanel p) {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setBackground(new java.awt.Color(50, 80, 90));

        Image img = Toolkit.getDefaultToolkit().getImage("lib//clipart2666120.png");
        this.setContentPane(new ImagePanel(img));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
             .addGap(78, 78, 78)
                .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        pack();
    }                      

}