package com.example.Repository;

import java.awt.Dimension;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.example.Main;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.bson.Document;
import org.bson.types.Binary;

public class ImageCards extends javax.swing.JPanel {

    MongoClient client = MongoClients.create("mongodb+srv://artistrymp4:artistrymp4project@artistry.zi4lf5v.mongodb.net/?retryWrites=true&w=majority");
    MongoDatabase db = client.getDatabase("artistry");
    MongoCollection<Document> col = db.getCollection("photos");

    private javax.swing.JLabel addLabel = new JLabel();
    private javax.swing.JTextField jTextField1 = new JTextField();
    private javax.swing.JPanel addTitle = new JPanel();

    Document doc;
    ImageIcon icon;
    public ImageCards(){}

    public ImageCards(ImageIcon i, Document d) {
        doc = d;
        icon = i;
        initComponents(i);
    }
                       
    private void initComponents(ImageIcon i) {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        this.setPreferredSize(new Dimension(234, 338));

        jLabel1.setPreferredSize(new Dimension(220, 244));
        jLabel1.setText("Demo");
        jLabel1.setIcon(i);
        jLabel1.setBorder(new LineBorder(Color.black));
        if ((boolean)doc.get("posted")) {
            jButton1.setText("Remove");
        } else {
            jButton1.setText("Post");
        }

        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(248,252,255));
        jButton2.setBackground(new java.awt.Color(248,252,255));
        jButton3.setBackground(new java.awt.Color(248,252,255));

        jButton2.setText("Download");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        deleteTag = new javax.swing.JLabel();
        yesDelete = new javax.swing.JButton();
        noDelete = new javax.swing.JButton();

        customPanel = new JPanel();
        deleteTag.setText("Are you sure you want to delete?");
        yesDelete.setText("Yes");
        yesDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesDeleteActionPerformed(evt);
            }
        });

        noDelete.setText("No");
        noDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout1 = new javax.swing.GroupLayout(customPanel);
        customPanel.setLayout(layout1);
        layout1.setHorizontalGroup(
            layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout1.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteTag, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout1.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yesDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout1.setVerticalGroup(
            layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout1.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(deleteTag, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yesDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noDelete)
                .addContainerGap(20, Short.MAX_VALUE))
        );

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
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { 
        boolean status = (boolean) doc.get("posted");     
        col.updateOne(Filters.eq("_id", doc.get("_id")), (Updates.set("posted", (!status))));
        if ((!status) == true) {
            String title = JOptionPane.showInputDialog(jLabel1.getParent(), "Add Title: ", "Image Title", JOptionPane.QUESTION_MESSAGE);
            col.updateOne(Filters.eq("_id", doc.get("_id")), (Updates.set("title", title)));
        }
        Main.iPad.initComponents(new MyImages());
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        JFileChooser chooser = new JFileChooser();
		int num = chooser.showSaveDialog(jLabel1.getParent());
		if(num == JFileChooser.APPROVE_OPTION) {
		    String test = chooser.getSelectedFile() +".png";
		    File f = new File(test);
            Binary imgFile = doc.get("val", org.bson.types.Binary.class);
                byte[] byteArray = imgFile.getData();
                ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
                BufferedImage bImage2 = null;
                try {
                    bImage2 = ImageIO.read(bis);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    ImageIO.write(bImage2, "png",f);
                } catch(IOException e) {
                    System.out.println("Write error for " + f.getPath() + ": " + e.getMessage());
                }
		    } 


            addLabel = new javax.swing.JLabel();
            jTextField1 = new javax.swing.JTextField();

            addTitle.setBackground(new java.awt.Color(248, 252, 255));

            addLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            addLabel.setText("Add Title");

        javax.swing.GroupLayout layoutA = new javax.swing.GroupLayout(addTitle);
        this.setLayout(layoutA);
        layoutA.setHorizontalGroup(
            layoutA.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layoutA.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layoutA.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteTag, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layoutA.setVerticalGroup(
            layoutA.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layoutA.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(deleteTag, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

    }     
    
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(jLabel1.getParent(), new LargeView(doc), "Your Image", JOptionPane.PLAIN_MESSAGE);
    } 

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {        
        JOptionPane.showConfirmDialog(jLabel1.getParent(), customPanel, "Confirm", JOptionPane.PLAIN_MESSAGE);
    }             
    
    private void yesDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                         
        col.deleteOne(Filters.eq("_id", doc.get("_id")));
        JOptionPane.getRootFrame().dispose();
        Main.iPad.initComponents(new MyImages());
    }                                         

    private void noDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                         
        JOptionPane.getRootFrame().dispose();
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel deleteTag;
    private javax.swing.JButton noDelete;
    private javax.swing.JButton yesDelete;
    private javax.swing.JPanel customPanel;

}