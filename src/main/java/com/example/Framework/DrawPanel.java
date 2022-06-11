package com.example.Framework;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import com.example.Main;
import com.example.Drawing.Coloring;
import com.example.Home.HomePage;
import com.example.Home.ViewImages;
import com.example.LineDraw.LineDraw;
import com.example.Photo.Edit;
import com.example.Repository.MyImages;
import com.example.Repository.SavedImages;

import java.awt.Color;
import java.awt.Dimension;

public class DrawPanel extends javax.swing.JPanel {

    private javax.swing.JButton create;
    private javax.swing.JButton home;
    private javax.swing.JPanel galleryPanel;
    private javax.swing.JLabel label;
    private javax.swing.JButton work;

    JPopupMenu popupMenu = new JPopupMenu();
    JMenuItem draw = new JMenuItem("Draw");
    JMenuItem upload = new JMenuItem("Upload");
    JMenuItem line = new JMenuItem("Line Draw");

    public static JPopupMenu workMenu = new JPopupMenu();
    public JMenuItem myImages = new JMenuItem("My Images");
    public JMenuItem saved = new JMenuItem("Saved Images");

    public DrawPanel(JPanel p) {
        initComponents(p);
    }
                       
    private void initComponents(JPanel p) {

        // jToolBar1 = new javax.swing.JToolBar();
        // homeButton = new javax.swing.JButton();
        // createButton = new javax.swing.JButton();
        // exploreButton = new javax.swing.JButton();
        home = new javax.swing.JButton();
        work = new javax.swing.JButton();
        create = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        galleryPanel = p;
        galleryPanel.setPreferredSize(new Dimension(468, 515));

        setBackground(new java.awt.Color(245,254,255));
        setPreferredSize(new java.awt.Dimension(487, 635));

        home.setBackground(new java.awt.Color(255, 255, 255));
        home.setFont(new java.awt.Font("Lucida Grande", 1, 22)); // NOI18N
        home.setText("🏠");
        home.setOpaque(true);
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        work.setBackground(new java.awt.Color(255, 255, 255));
        work.setFont(new java.awt.Font("Lucida Grande", 1, 22)); // NOI18N
        work.setText("🎨");
        work.setOpaque(true);
        work.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workActionPerformed(evt);
            }
        });

        create.setBackground(new java.awt.Color(255, 255, 255));
        create.setFont(new java.awt.Font("Lucida Grande", 1, 22)); // NOI18N
        create.setText("➕");
        create.setOpaque(true);
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });

        label.setFont(new java.awt.Font("Academy Engraved LET", 1, 48)); // NOI18N
        label.setForeground(Color.BLACK);
        label.setText("a r t i s t r y");

        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Main.iPad.initComponents(new ViewImages());
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(label)
                .addGap(18, 18, 18)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(create, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(work, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(galleryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(work, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(create, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(home)))
                .addComponent(galleryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        draw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Main.iPad.initComponents(new Coloring());
            }
        });
        line.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Main.iPad.initComponents(new DrawPanel(new LineDraw()));
        }
        });
        upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Main.iPad.initComponents(new DrawPanel(new Edit()));
            }
        });

        myImages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Main.iPad.initComponents(new MyImages());
            }
        });
        saved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Main.iPad.initComponents(new SavedImages());
        }
        });

        
    }                     

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {                                     
        Main.iPad.initComponents(new HomePage());
    }                                    

    private void workActionPerformed(java.awt.event.ActionEvent evt) {                                     
        workMenu = new JPopupMenu();                                    
        workMenu.add(myImages);    
        workMenu.add(saved);                               
        workMenu.show(work, work.getWidth()/60, work.getHeight()/1);
    }                          
    
    

    private void createActionPerformed(java.awt.event.ActionEvent evt) {                                       
        popupMenu.add(draw);    
        popupMenu.add(line);  
        popupMenu.add(upload);                               
        popupMenu.show(create, create.getWidth()/60, create.getHeight()/1);
    }     
    
}